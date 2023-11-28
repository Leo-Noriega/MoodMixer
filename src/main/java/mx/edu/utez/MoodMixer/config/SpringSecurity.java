package mx.edu.utez.MoodMixer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
                .authorizeRequests().requestMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().oauth2Login(oauth -> oauth.loginPage("/login").defaultSuccessUrl("/callback"));
        return http.build();
    }
}
