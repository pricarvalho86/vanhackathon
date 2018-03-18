package com.skipthedishes.vanhackathon.customer;

public class CustomerAuthenticateRequest {

    private final String email;
    private final String password;

    public CustomerAuthenticateRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
