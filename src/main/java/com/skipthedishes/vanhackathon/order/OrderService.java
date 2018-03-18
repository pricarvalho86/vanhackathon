package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.order.models.OrderItem;
import com.skipthedishes.vanhackathon.order.models.Order;
import com.skipthedishes.vanhackathon.product.Product;
import com.skipthedishes.vanhackathon.product.ProductRepository;
import com.skipthedishes.vanhackathon.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {

    private OrderRepository orders;
    private ProductRepository products;

    @Autowired
    public OrderService(OrderRepository orders, ProductRepository products) {
        this.orders = orders;
        this.products = products;
    }

    @Transactional
    public Order create(OrderCreateRequest orderRequest) {
        Customer customer = null;
        Stream<OrderItem> items = orderRequest.getOrderItems().stream().map(orderItem -> {
            Optional<Product> product = products.findById(orderItem.getProductId());
            OrderItem item = product.map(p -> new OrderItem(orderItem.getQuantity(), p)).get();
            return item;
        });
        Store store = items.findFirst().map(orderItem -> orderItem.getStore()).get();
        Order order = orderRequest.create(customer, store, items.collect(Collectors.toList()));
        return orders.save(order);
    }
}
