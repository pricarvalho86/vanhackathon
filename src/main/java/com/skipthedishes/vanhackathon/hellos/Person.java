package com.skipthedishes.vanhackathon.hellos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Deprecated
    Person(){}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
