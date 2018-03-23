package com.skipthedishes.vanhackathon.auth;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

public class TokenAuthenticationService {

    private static final long EXPIRATION_TIME = 860_000_000; //TODO ADD TO application.properties
    private static final String SECRET = "vanhackathon"; //TODO ADD TO application.properties
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    public static void addHeaderAuthentication(HttpServletResponse response, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public static Optional<Authentication> getAuthentication(HttpServletRequest request) {
        Optional<String> tokenHeaderRequest = Optional.ofNullable(request.getHeader(HEADER_STRING));
        return tokenHeaderRequest.flatMap(token -> {
            Optional<String> user = recoverUserLoggedInByToken(token);
            return user.map(u -> new UsernamePasswordAuthenticationToken(u, null, Collections.emptyList()));
        });
    }

    public static Optional<String> recoverUserLoggedInByToken(String token) {
        return Optional.ofNullable(
                        Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject());
    }

}
