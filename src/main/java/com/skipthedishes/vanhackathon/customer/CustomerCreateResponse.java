package com.skipthedishes.vanhackathon.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

public class CustomerCreateResponse {

    private String email;
    private String name;
    private String address;
    private Date creation;

    public CustomerCreateResponse(String email, String name, String address, Date creation) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.creation = creation;
    }

    public static CustomerCreateResponse from(Customer customer) {
        return new CustomerCreateResponse(
                        customer.getEmail(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getCreation());
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getCreation() {
        return creation;
    }
}
