package com.skipthedishes.vanhackathon.order.models;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.store.Store;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdate;

    @ManyToOne
    private Store store;

    @ManyToOne(optional = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems;

    @Deprecated
    protected Order() {}

    public Order(String deliveryAddress, String contact, Status status, Store store, Customer customer, List<OrderItem> orderItems) {
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.status = status;
        this.store = store;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public Double total() {
        return orderItems.stream().mapToDouble(orderItem -> orderItem.total()).sum();
    }
}
