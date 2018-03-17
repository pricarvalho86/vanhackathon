package com.skipthedishes.vanhackathon.cousine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Cousine")
public class CousineResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> list() {
//        Person person = service.create(new Person(name));
        return ResponseEntity.ok().body("Get cousines ");
    }

    @RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<String> search(@PathVariable("searchText") String searchText) {
//        Person person = service.create(new Person(name));
        return ResponseEntity.ok().body("Searching " +searchText );
    }

    @RequestMapping(value = "/{cousineId}/stores", method = RequestMethod.GET)
    public ResponseEntity<String> stores(@PathVariable("cousineId") String cousineId) {
//        Person person = service.create(new Person(name));
        return ResponseEntity.ok().body("Stores from "+cousineId);
    }

}
