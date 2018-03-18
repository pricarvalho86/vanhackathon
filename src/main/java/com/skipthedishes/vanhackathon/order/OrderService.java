package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.customer.CustomerRepository;
import com.skipthedishes.vanhackathon.order.models.Item;
import com.skipthedishes.vanhackathon.product.Product;
import com.skipthedishes.vanhackathon.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class OrderService {

    private CustomerRepository orders;
    private ProductRepository products;

    @Autowired
    public OrderService(CustomerRepository orders, ProductRepository products) {
        this.orders = orders;
        this.products = products;
    }

    public void create(OrderCreateRequest orderRequest) {
        Stream<Item> items = orderRequest.getItems().stream().map(itemRequest -> {
            Optional<Product> product = products.findById(itemRequest.getProductId());
            Item item = product.map(p -> new Item(itemRequest.getQuantity(), p)).get();
            return item;
        });
//        orderRequest.createOrderWithItems(Arrays.asList(items));
        return;
    }
}
