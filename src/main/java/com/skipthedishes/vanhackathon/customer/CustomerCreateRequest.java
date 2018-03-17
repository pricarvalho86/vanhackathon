package com.skipthedishes.vanhackathon.customer;

public class CustomerCreateRequest {

    private final String email;
    private final String name;
    private final String address;
    private final String password;

    public CustomerCreateRequest(String email, String name, String address, String password){

        this.email = email;
        this.name = name;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Customer toCustomer() {
        return new Customer(email, name, address, password);
    }
}
