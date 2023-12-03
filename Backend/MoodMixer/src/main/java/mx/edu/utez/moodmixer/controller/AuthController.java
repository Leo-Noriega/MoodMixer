package mx.edu.utez.moodmixer.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RequestMapping("/moodmixer")
public class AuthController {
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
    private static final String SCOPE = "user-read-private user-read-email";
    private static final String REDIREC_URI = "http://localhost:8888/moodmixer/callback";

    public String token = "";


    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @GetMapping("/authorize")
    public ResponseEntity<Void> authorize(RedirectAttributes redirectAttributes) {

        String state = generateRandomString(16);

        URI redirectUri = UriComponentsBuilder.fromHttpUrl("https://accounts.spotify.com/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", CLIENT_ID)
                .queryParam("scope", SCOPE)
                .queryParam("redirect_uri", REDIREC_URI)
                .queryParam("state", state)
                .build().toUri();

        return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();
    }

    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @GetMapping("/callback")
    public void callback(@RequestParam(required = false) String code,
                         @RequestParam(required = false) String state,
                         HttpServletResponse response) throws IOException {


        if (code == null || state == null) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/moodmixer/authorize")
                    .queryParam("error", "state_mismatch");
            response.sendRedirect("http://localhost:5500/error_auth.html");
        }

        MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("code", code);
        bodyMap.add("redirect_uri", REDIREC_URI);
        bodyMap.add("grant_type", "authorization_code");

        String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + encodedCredentials);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://accounts.spotify.com/api/token",
                HttpMethod.POST, requestEntity, String.class);
        // redirigirla a el controlle /home con el token
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = mapper.readValue(responseEntity.getBody(), new TypeReference<>() {
        });

        token = (String) jsonMap.get("access_token");
        response.sendRedirect("http://localhost:8888/moodmixer/home");
        // return new RedirectView("http://localhost:5500/index.html");
    }

    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @GetMapping("/home")
    public void home(HttpServletResponse response, HttpSession session) throws IOException {
        response.sendRedirect("http://localhost:5500/index.html");
    }

    @CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
    @GetMapping("/data")
    public ResponseEntity<String> data(HttpSession session) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<String> requestEntity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(
                "https://api.spotify.com/v1/me", HttpMethod.GET, requestEntity, String.class);

        return ResponseEntity.ok().body(Objects.requireNonNull(result.getBody()));
    }

    private String generateRandomString(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[length];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

}
