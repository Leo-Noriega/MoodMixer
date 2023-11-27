package mx.edu.utez.MoodMixer.controller;

import mx.edu.utez.MoodMixer.model.dto.UserDto;
import mx.edu.utez.MoodMixer.service.impl.UserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserImpl userImpl;

    public AuthController(UserImpl userImpl) {
        this.userImpl = userImpl;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
}
