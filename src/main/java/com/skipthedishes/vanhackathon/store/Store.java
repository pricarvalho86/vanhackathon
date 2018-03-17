package com.skipthedishes.vanhackathon.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
}
