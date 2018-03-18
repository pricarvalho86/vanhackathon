package com.skipthedishes.vanhackathon.order.models;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.store.Store;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Orders implements Serializable {

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

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="order_item",
            joinColumns={@JoinColumn(name="order_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="item_id", referencedColumnName="id")})
    private List<Item> items;

    @Deprecated
    protected Orders() {}

    public Orders(String deliveryAddress, String contact, Status status, Store store, Customer customer, List<Item> items) {
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
