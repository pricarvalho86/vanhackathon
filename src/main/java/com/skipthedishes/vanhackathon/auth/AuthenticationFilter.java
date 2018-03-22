package com.skipthedishes.vanhackathon.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class AuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Optional<Authentication> authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) request);
        authentication.ifPresent(auth -> {
            SecurityContextHolder.getContext().setAuthentication(auth);
        });
        filterChain.doFilter(request, response);
    }

}
