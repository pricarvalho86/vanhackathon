package com.skipthedishes.vanhackathon.customer;

public class CustomerAuthenticateResponse {

    private String token;

    public CustomerAuthenticateResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
