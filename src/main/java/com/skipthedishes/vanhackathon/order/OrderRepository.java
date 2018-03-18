package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.order.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> { }
