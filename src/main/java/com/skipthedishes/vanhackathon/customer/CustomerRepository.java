package com.skipthedishes.vanhackathon.customer;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findFirstByEmailEquals(String email);


}
