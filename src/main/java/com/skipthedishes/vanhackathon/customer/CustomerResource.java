package com.skipthedishes.vanhackathon.customer;

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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody CustomerCreateRequest request) {
        return ResponseEntity.ok().body("Registering customer "+request.getName());
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
