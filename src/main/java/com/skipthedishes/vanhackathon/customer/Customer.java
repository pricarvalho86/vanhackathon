package com.skipthedishes.vanhackathon.customer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false)
    private Date creation;

    @Deprecated
    protected Customer(){}

    public Customer(String email, String name, String address, String password){
        this.email = email;
        this.name = name;
        this.address = address;
        this.password = password;
    }

}
