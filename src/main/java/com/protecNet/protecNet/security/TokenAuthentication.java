package com.protecNet.protecNet.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TokenAuthentication
        extends AbstractAuthenticationToken
{
    String token;

    String subject;

    String rol;

    public TokenAuthentication( String token, String subject, String rol )
    {
        super( null );
        this.token = token;
        this.subject = subject;
        this.rol = rol;
    }

    @Override
    public boolean isAuthenticated()
    {
        return !token.isEmpty() && !subject.isEmpty() && !rol.isEmpty();
    }

    @Override
    public Object getCredentials()
    {
        return token;
    }

    @Override
    public Object getPrincipal()
    {
        return subject;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority( rol ));
        return roles;
    }


}
