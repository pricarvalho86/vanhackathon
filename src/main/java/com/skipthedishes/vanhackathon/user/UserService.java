package com.skipthedishes.vanhackathon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private UserRepository users;

    @Autowired
    public UserService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.findFirstByUsernameEquals(username)
                    .map(user -> {
                        return User.withUsername(username)
                                .password(user.getPassword())
                                .authorities(Collections.emptyList())
                                .build();
                    }).get();
    }
}
