package com.skipthedishes.vanhackathon.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Product")
public class ProductResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> list() {
        return ResponseEntity.ok().body("Get cousines ");
    }

    @RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<String> search(@PathVariable("searchText") String searchText) {
        return ResponseEntity.ok().body("Searching " +searchText );
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ResponseEntity<String> stores(@PathVariable("productId") String productId) {
        return ResponseEntity.ok().body("Product from "+productId);
    }

}
