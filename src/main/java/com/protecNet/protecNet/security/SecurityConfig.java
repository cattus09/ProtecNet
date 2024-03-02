package com.protecNet.protecNet.security;


import com.protecNet.protecNet.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import static com.protecNet.protecNet.security.URLManager.FREE_URLS;
import static com.protecNet.protecNet.security.URLManager.PROTECTED_URLS;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private UsersService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .headers(HeadersConfigurer -> HeadersConfigurer.frameOptions(FrameOptionsConfig::sameOrigin))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(scp -> scp.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests(authorizeRequest ->
                        authorizeRequest
                                .requestMatchers(FREE_URLS)
                                .permitAll()

                                .requestMatchers(PROTECTED_URLS).authenticated()
                )
                .addFilterBefore(jwtRequestFilter, FilterSecurityInterceptor.class);
        return http.build();
    }
}
