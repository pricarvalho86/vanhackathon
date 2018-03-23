package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.order.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Order")
public class OrderResource {

    private OrderService service;

    @Autowired
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public @ResponseBody Order get(@PathVariable Long orderId) {
        return service.findById(orderId).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Order register(@RequestBody OrderCreateRequest orderRequest, @RequestHeader("Authorization") String token) {
        return service.create(orderRequest, token);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public @ResponseBody String customer() {
        return "Get orders from customers ";
    }

}
