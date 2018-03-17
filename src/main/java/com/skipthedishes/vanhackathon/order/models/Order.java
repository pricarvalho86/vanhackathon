package com.skipthedishes.vanhackathon.order.models;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.store.Store;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdate;

    private Store store;
    private Customer customer;
    private List<OrderItem> items;

    public Order(String deliveryAddress, String contact, String status, Store store, Customer customer, List<OrderItem> items) {
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.status = status;
        this.store = store;
        this.customer = customer;
        this.items = items;
    }

    public Double total() {
        return items.stream().mapToDouble(item -> item.total()).sum();
    }
}
