package com.skipthedishes.vanhackathon.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/api/v1/Customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CustomerResource {

    private CustomerService service;

    @Autowired
    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody CustomerCreateResponse register(@RequestBody CustomerCreateRequest request) {
        Customer customer = service.save(request);
        return  CustomerCreateResponse.from(customer);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public @ResponseBody String authenticate(@RequestBody CustomerAuthenticationRequest request) {
        return  "Foi autenticado";
    }
}
