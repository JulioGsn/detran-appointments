package com.example.detran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/api/info").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/candidates/**", "/exams/**", "/exam-appointments/**", "/exam-results/**")
                    .hasAnyRole("ADMIN", "EXAMINER", "ATTENDANT")
                .requestMatchers(HttpMethod.PUT, "/candidates/**", "/exams/**", "/exam-appointments/**", "/exam-results/**")
                    .hasAnyRole("ADMIN", "EXAMINER")
                .requestMatchers(HttpMethod.POST, "/candidates/**", "/exams/**", "/exam-appointments/**", "/exam-results/**")
                    .hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/candidates/**", "/exams/**", "/exam-appointments/**", "/exam-results/**")
                    .hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .build();
    }

    @Bean
    public InMemoryUserDetailsManager users() {
        UserDetails admin = User.withUsername("admin")
            .password("{noop}admin123")
            .roles("ADMIN")
            .build();
        UserDetails examiner = User.withUsername("examiner")
            .password("{noop}examiner123")
            .roles("EXAMINER")
            .build();
        UserDetails attendant = User.withUsername("attendant")
            .password("{noop}attendant123")
            .roles("ATTENDANT")
            .build();

        return new InMemoryUserDetailsManager(admin, examiner, attendant);
    }
}
