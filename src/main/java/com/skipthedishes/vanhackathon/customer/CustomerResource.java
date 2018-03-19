package com.skipthedishes.vanhackathon.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public @ResponseBody CustomerCreateResponse register(@RequestBody CustomerCreateRequest customerRequest) {
        Customer customer = service.save(customerRequest);
        return  CustomerCreateResponse.from(customer);
    }

//    @RequestMapping(value = "/auth", method = RequestMethod.POST)
//    public @ResponseBody CustomerAuthenticateResponse authenticate(@RequestBody CustomerAuthenticateRequest customerAuthenticateRequest) {
//        Optional<String> token = service.authenticate(customerAuthenticateRequest);
//        Optional<CustomerAuthenticateResponse> customerAuthResponse = token.map(CustomerAuthenticateResponse::new);
//        return customerAuthResponse.orElseThrow(() -> new UnauthorizedException());
//    }
}
