package com.lecimangga.lecimanggaresidence.security;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(l -> l.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/hubungi-kami/insert")))
                .authorizeHttpRequests(authorizeRequests ->{
                        authorizeRequests.anyRequest().permitAll();
                                    });
        return http.build();
    }

}
