package com.skipthedishes.vanhackathon.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customers;

    @Autowired
    public CustomerService(CustomerRepository customers) {
        this.customers = customers;
    }

    public Customer save(CustomerCreateRequest customerRequest) {
        Customer customer = customerRequest.toCustomer();
        return customers.save(customer);
    }

}
