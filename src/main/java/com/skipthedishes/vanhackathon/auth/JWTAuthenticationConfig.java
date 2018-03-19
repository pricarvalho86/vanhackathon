package com.skipthedishes.vanhackathon.auth;

public enum JWTAuthenticationConfig {

    SECRET("vanhackathon"),
    TOKEN_PREFIX("Bearer"),
    HEADER_STRING("Authorization"),
    EXPIRATION_TIME("860_000_000");

    private String value;

    JWTAuthenticationConfig(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
