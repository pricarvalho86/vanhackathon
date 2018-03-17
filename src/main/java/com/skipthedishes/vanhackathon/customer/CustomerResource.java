package com.skipthedishes.vanhackathon.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/Customer")
public class CustomerResource {

    private CustomerService service;

    @Autowired
    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> register(@RequestBody CustomerCreateRequest request) {
        Customer customer = service.save(request.toCustomer());
        return ResponseEntity.ok().body(customer);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<String> authenticate(@RequestBody CustomerAuthenticationRequest request) {
        //TODO RETURN A TOKEN
        try {
            return ResponseEntity.created(new URI("/success")).body("Authentication success to "+request.getEmail());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
