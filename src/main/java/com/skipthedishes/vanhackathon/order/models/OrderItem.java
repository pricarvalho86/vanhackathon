package com.skipthedishes.vanhackathon.order.models;

import com.skipthedishes.vanhackathon.product.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    private Product product;

    @Deprecated
    protected OrderItem() {}

    public OrderItem(Integer quantity, Product product) {
        this.price = product.price();
        this.quantity = quantity;
        this.product = product;
    }

    public Double total() {
        return this.price * this.quantity ;
    }
}
