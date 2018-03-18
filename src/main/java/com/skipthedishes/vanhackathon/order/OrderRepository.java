package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.order.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long> { }
