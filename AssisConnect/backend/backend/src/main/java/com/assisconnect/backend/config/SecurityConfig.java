package com.assisconnect.backend.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrf -> csrf.disable())
            .cors(Customizer.withDefaults())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .requestMatchers("/api/auth/**").permitAll()
                    .requestMatchers("/uploads/**").permitAll() // 👈 ADICIONA ISSO AQUI
                    .requestMatchers("/error", "/favicon.ico", "/assets/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/idosos/count").hasAnyRole("ADMIN", "FUNCIONARIO", "FAMILIAR")
                    .requestMatchers(HttpMethod.GET, "/api/idosos/aniversariantes").hasAnyRole("ADMIN", "FUNCIONARIO", "FAMILIAR")
                    .requestMatchers(HttpMethod.GET, "/api/usuarios").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/api/usuarios/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/idosos").hasAnyRole("ADMIN", "FUNCIONARIO")
                    .anyRequest().authenticated())

            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}

    @Bean
    public CorsConfigurationSource corsConfigurationSource(
            @Value("${app.cors.allowed-origin}") String allowedOrigin) {
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.setAllowedOrigins(List.of(allowedOrigin));
        cfg.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        cfg.setAllowedHeaders(List.of("*"));
        cfg.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}
