package com.skipthedishes.vanhackathon.store;

import com.skipthedishes.vanhackathon.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Store implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Deprecated
    protected Store() {}

    public Store(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
