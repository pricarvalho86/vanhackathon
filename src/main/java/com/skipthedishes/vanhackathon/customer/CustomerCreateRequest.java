package com.skipthedishes.vanhackathon.customer;

public class CustomerCreateRequest {

    private String email;
    private String name;
    private String address;
    private String password;

    public Customer toCustomer() {
        return new Customer(email, name, address, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
