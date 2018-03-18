package com.skipthedishes.vanhackathon.customer;

import com.skipthedishes.vanhackathon.store.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {


}
