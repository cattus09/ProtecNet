package com.protecNet.protecNet.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.protecNet.protecNet.security.URLManager.FREE_URLS;


@Component
public class JwtRequestFilter extends OncePerRequestFilter
{
    @Value( "${jwt.secret}" )
    String secret;

    public JwtRequestFilter()
    {
    }

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        String authHeader = request.getHeader( HttpHeaders.AUTHORIZATION );
        if ( HttpMethod.OPTIONS.name().equals( request.getMethod() ) )
        {
            response.setStatus( HttpServletResponse.SC_OK );
            filterChain.doFilter( request, response );
        }
        else if (FREE_URLS.matches(request)){
            filterChain.doFilter( request, response );
        }
        else if (authHeader == null){
            response.sendError( HttpStatus.UNAUTHORIZED.value(), "Missing token" );
        }
        else{
            try
            {
                String headerJwt = authHeader.substring( 7 );
                Jws<Claims> claims = Jwts.parser().setSigningKey( secret ).parseClaimsJws( headerJwt );
                Claims claimsBody = claims.getBody();
                String subject = claimsBody.getSubject();
                String rol  = claims.getBody().get( "ROL", String.class);

                if (rol == null) {
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid token roles");
                } else {
                    SecurityContextHolder.getContext().setAuthentication( new TokenAuthentication( headerJwt, subject, rol));
                }

                request.setAttribute( "claims", claimsBody );
                request.setAttribute( "jwtUserId", subject );
                request.setAttribute("jwtUserRol", rol);

                filterChain.doFilter( request, response );
            }
            catch ( MalformedJwtException e )
            {
                response.sendError( HttpStatus.BAD_REQUEST.value(), "Missing or wrong token" );
            }
            catch ( ExpiredJwtException e )
            {
                response.sendError( HttpStatus.UNAUTHORIZED.value(), "Token expired or malformed" );
            }
        }
    }

}