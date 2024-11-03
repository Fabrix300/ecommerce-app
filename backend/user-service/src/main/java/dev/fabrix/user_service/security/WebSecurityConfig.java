package dev.fabrix.user_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // http.csrf().disable() // Deshabilitar CSRF para simplificar en esta etapa
    // .authorizeRequests()
    // .antMatchers("/api/users/register", "/api/users/login").permitAll()
    // .anyRequest().authenticated();
    // }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/users/register", "/api/users/login").permitAll()
                .anyRequest().authenticated()).csrf(csrf -> csrf.disable());
        return http.build();
    }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder(); // Para encriptar contraseñas
    // }
}
