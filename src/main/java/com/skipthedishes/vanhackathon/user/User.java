package com.skipthedishes.vanhackathon.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String email;

    private String password;

    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(nullable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(nullable = false)
    private Date lastLoginDate;

    /**
     * @deprecated: Hibernate Eyes Only
     */
    @Deprecated
    User() {}

    public User(String email, String password) {
        this.email = email.toLowerCase();
        this.password = password;
    }

    @PrePersist
    private void encriptPassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

    public User generateToken(UserRepository users) throws UnsupportedEncodingException {
        Algorithm algorithmHMAC = Algorithm.HMAC256(this.id);
        this.token =  JWT.create().withIssuer("auth0").sign(algorithmHMAC);
        return users.save(this);
    }

    public boolean isValidPassword(String password) {
        return new BCryptPasswordEncoder().matches(password, this.password);
    }

    public String getToken() {
        return token;
    }
}

