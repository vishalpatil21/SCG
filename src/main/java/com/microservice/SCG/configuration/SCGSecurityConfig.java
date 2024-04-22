package com.microservice.SCG.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
public class SCGSecurityConfig {
    @Bean
    public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(HttpMethod.GET, "/product/**").permitAll()
                        .pathMatchers(HttpMethod.DELETE, "/product/**").hasRole("ADMIN")
                        .pathMatchers(HttpMethod.GET, "/order/**").permitAll()
                        .pathMatchers(HttpMethod.DELETE, "/order/**").hasRole("ADMIN")
                        .anyExchange().authenticated())
                .build();
    }
}
