package com.skipthedishes.vanhackathon.product;

import com.skipthedishes.vanhackathon.store.Store;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Store store;

    @Deprecated
    protected Product() {}

    public Product (String name, String description, Double price, Store store) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.store = store;
    }

    public Double price() {
        return this.price;
    }
}
