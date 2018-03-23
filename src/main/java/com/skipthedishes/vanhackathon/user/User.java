package com.skipthedishes.vanhackathon.user;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(nullable = false)
    private Date lastLoginDate;

    @Deprecated
    User() {}

    public User(String username, String password) {
        this.username = username.toLowerCase();
        this.password = password;
    }

    @PrePersist
    private void encriptPassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

    public boolean isValidPassword(String password) {
        return new BCryptPasswordEncoder().matches(password, this.password);
    }

    public String getPassword() {
        return password;
    }
}

