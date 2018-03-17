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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId",  referencedColumnName = "id")
    private List<Product> products;

    @Deprecated
    protected Store() {}

    public Store(String name) {
        this.name = name;
    }
}
