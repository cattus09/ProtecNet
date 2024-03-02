package com.protecNet.protecNet.security;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class URLManager {
    public static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/v1/auth/users"),
            new AntPathRequestMatcher("/v1/companies/**")
    );

    public static final RequestMatcher FREE_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/v1/auth/login"),
            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/h2-console*"),
            new AntPathRequestMatcher("/v1/auth/password/**"),
            new AntPathRequestMatcher("/*.ico")
    );
}
