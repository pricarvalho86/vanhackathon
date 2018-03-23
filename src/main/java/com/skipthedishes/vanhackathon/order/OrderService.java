package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.customer.CustomerRepository;
import com.skipthedishes.vanhackathon.order.models.OrderItem;
import com.skipthedishes.vanhackathon.order.models.Order;
import com.skipthedishes.vanhackathon.product.Product;
import com.skipthedishes.vanhackathon.product.ProductRepository;
import com.skipthedishes.vanhackathon.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {

    private OrderRepository orders;
    private ProductRepository products;
    private CustomerRepository customers;

    @Autowired
    public OrderService(OrderRepository orders, ProductRepository products, CustomerRepository customers) {
        this.orders = orders;
        this.products = products;
        this.customers = customers;
    }

    @Transactional
    public Order create(OrderCreateRequest orderRequest) {
        Optional<Customer> customerFound = customers.findFirstByEmailEquals("pri.carvalho86@gmail.com");

        Optional<Order> savedOrder = customerFound.map(customer -> {
            List<OrderItem> items = orderRequest.getOrderItems().stream().map(orderItem -> {
                Optional<Product> product = products.findById(orderItem.getProductId());
                OrderItem item = product.map(p -> new OrderItem(orderItem.getQuantity(), p)).get();
                return item;
            }).collect(Collectors.toList());
            Store store = items.stream().findFirst().map(orderItem -> orderItem.getStore()).get();
            return orderRequest.create(customer, store, items);
        }).map(order -> orders.save(order));

        return savedOrder.get();
    }
}
