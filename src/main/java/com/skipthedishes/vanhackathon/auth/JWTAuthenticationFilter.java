package com.skipthedishes.vanhackathon.auth;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import static com.skipthedishes.vanhackathon.auth.JWTAuthenticationConfig.*;

public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        Optional<String> tokenRequest = Optional.ofNullable(req.getHeader(HEADER_STRING.value()));

        Optional<UsernamePasswordAuthenticationToken> authenticationToken = tokenRequest.flatMap(token -> {
            Optional<String> user = Optional.ofNullable(Jwts.parser()
                    .setSigningKey(SECRET.value())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX.value(), ""))
                    .getBody()
                    .getSubject());

            return user.map(u -> new UsernamePasswordAuthenticationToken(u, null, Collections.emptyList()));
        });

        authenticationToken.ifPresent(authentication -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });

        filterChain.doFilter(request, response);
    }

}
