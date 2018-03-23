package com.skipthedishes.vanhackathon.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository products;

    @Autowired
    public ProductService(ProductRepository products) {
        this.products = products;
    }

    public Iterable<Product> list() {
        return products.findAll();
    }

    public Optional<Product> findById(Long productId) {
        return products.findById(productId);
    }
}
