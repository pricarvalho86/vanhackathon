package com.skipthedishes.vanhackathon.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/Order")
public class OrderResource {

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<String> get(@PathVariable String orderId) {
        return ResponseEntity.ok().body("Get cousines ");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody OrderCreateRequest request) {
        try {
            return ResponseEntity.created(new URI("")).body("Get cousines ");
        } catch (URISyntaxException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<String> customer() {
        return ResponseEntity.ok().body("Get cousines ");
    }

}
