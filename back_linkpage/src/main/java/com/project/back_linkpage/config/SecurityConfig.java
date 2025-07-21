package com.project.back_linkpage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        // Permite que qualquer um faça requisições GET para /users e /links
                        .requestMatchers(HttpMethod.GET, "/users/**", "/links/**").permitAll()
                        // Permite a criação de novos usuários (cadastro)
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        // Exige autenticação para qualquer outra requisição (POST, PUT, DELETE, etc.)
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
