package com.skipthedishes.vanhackathon.customer;

import com.skipthedishes.vanhackathon.user.User;
import com.skipthedishes.vanhackathon.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customers;
    private UserRepository users;

    @Autowired
    public CustomerService(CustomerRepository customers, UserRepository users) {
        this.customers = customers;
        this.users = users;
    }

    public Customer save(CustomerCreateRequest customerRequest) {
        Customer customer = customerRequest.toCustomer();
        return customers.save(customer);
    }

    public Optional<String> authenticate(CustomerAuthenticateRequest userAuthenticateRequest) {
        return users.findFirstByEmailEquals(userAuthenticateRequest.getEmail())
            .filter(user -> user.isValidPassword(userAuthenticateRequest.getPassword()))
            .flatMap(user -> {
                try {
                    return Optional.of(user.generateToken(users));
                } catch (UnsupportedEncodingException e) {
                    return Optional.empty();
                }
            }).map(User::getToken);
    }
}
