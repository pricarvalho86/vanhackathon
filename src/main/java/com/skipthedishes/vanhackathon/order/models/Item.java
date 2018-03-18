package com.skipthedishes.vanhackathon.order.models;

import com.skipthedishes.vanhackathon.product.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinTable(name="order_item",
            joinColumns={@JoinColumn(name="item_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="order_id", referencedColumnName="id")})
    private Orders orders;

    @Deprecated
    protected Item() {}

    public Item(Integer quantity, Product product) {
        this.price = product.price();
        this.quantity = quantity;
        this.product = product;
    }

    public Double total() {
        return this.price * this.quantity ;
    }

}
