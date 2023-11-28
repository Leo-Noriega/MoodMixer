package mx.edu.utez.MoodMixer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(customizeRequests -> {
                            customizeRequests
                                    .requestMatchers("/api/login", "/styles/**", "/js/**").permitAll()
                                    .anyRequest().authenticated();
                        }
                )
                .formLogin(form -> {
                    form.loginPage("/login.html");
                    form.failureUrl("/login?error");
                    form.defaultSuccessUrl("/index.html");
                    form.permitAll();
                });

        return http.build();
    }
}
