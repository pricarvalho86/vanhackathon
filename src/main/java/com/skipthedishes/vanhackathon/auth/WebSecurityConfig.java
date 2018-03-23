package com.skipthedishes.vanhackathon.auth;

import com.skipthedishes.vanhackathon.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService service;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
            .antMatchers(HttpMethod.POST,"/api/v1/Customer").permitAll()
            .antMatchers(HttpMethod.GET,"/api/v1/Product", "/api/v1/Product/*").permitAll()
            .antMatchers(HttpMethod.POST, "/api/v1/Customer/auth").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(new LoginFilter("/api/v1/Customer/auth", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
    }
}
