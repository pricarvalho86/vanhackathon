package com.skipthedishes.vanhackathon.customer;

public class CustomerAuthenticationRequest {

    private final String email;
    private final String password;

    public CustomerAuthenticationRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}
