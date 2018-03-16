package com.skipthedishes.vanhackathon.hellos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hellos")
public class HelloResource {

    private PersonService service;

    @Autowired
    HelloResource(PersonService service){
        this.service = service;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> index(@PathVariable("name") String name) {
        Person person = service.create(new Person(name));
        return ResponseEntity.ok().body("Hello, "+person.getName()+"-> Id: "+person.getId());
    }
}
