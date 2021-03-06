package com.skipthedishes.vanhackathon.order.models;

import com.skipthedishes.vanhackathon.product.Product;
import com.skipthedishes.vanhackathon.store.Store;

import javax.persistence.*;
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

    @OneToOne
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Order order;

    @Deprecated
    protected OrderItem() {}

    public OrderItem(Integer quantity, Product product) {
        this.price = product.getPrice();
        this.quantity = quantity;
        this.product = product;
    }

    public Double total() {
        return this.price * this.quantity ;
    }

    public Store getStore() {
        return this.product.getStore();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }


}
