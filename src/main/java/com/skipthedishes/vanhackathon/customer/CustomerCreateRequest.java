package com.skipthedishes.vanhackathon.customer;

public class CustomerCreateRequest {

    private String email;
    private String name;
    private String address;
    private String password;

    public CustomerCreateRequest(String email, String name, String address, String password){
        this.email = email;
        this.name = name;
        this.address = address;
        this.password = password;
    }

    public Customer toCustomer() {
        return new Customer(email, name, address, password);
    }
}
