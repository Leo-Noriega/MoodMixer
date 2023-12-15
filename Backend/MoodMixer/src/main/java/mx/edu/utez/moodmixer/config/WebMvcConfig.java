package mx.edu.utez.moodmixer.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {

    public static final String[] ALLOWED_ORIGINS = {"http://localhost:5500", "http://127.0.0.1:5500"};

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowCredentials(true);
    }
}
