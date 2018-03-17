package com.skipthedishes.vanhackathon.store;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Store")
public class StoreResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> list() {
        return ResponseEntity.ok().body("Get cousines ");
    }

    @RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<String> search(@PathVariable("searchText") String searchText) {
        return ResponseEntity.ok().body("Searching " +searchText );
    }

    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<String> get(@PathVariable("storeId") String storeId) {
        return ResponseEntity.ok().body("Store from "+storeId);
    }

    @RequestMapping(value = "/{storeId}/products", method = RequestMethod.GET)
    public ResponseEntity<String> products(@PathVariable("storeId") String storeId) {
        return ResponseEntity.ok().body("Store from "+storeId);
    }

}
