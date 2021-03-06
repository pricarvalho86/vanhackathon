package com.skipthedishes.vanhackathon.customer;

import com.skipthedishes.vanhackathon.user.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false)
    private Date creation;

    @Deprecated
    Customer(){}

    public Customer (String email, String name, String address, String password) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.user = new User(email, password);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getCreation() {
        return creation;
    }
}
