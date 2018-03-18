package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.order.models.Item;
import com.skipthedishes.vanhackathon.order.models.Orders;
import com.skipthedishes.vanhackathon.order.models.Status;
import com.skipthedishes.vanhackathon.store.Store;

import java.util.List;

public class OrderCreateRequest {

    private final String contact;
    private final String deliveryAddress;
    private final List<ItemCreateRequest> items;

    public OrderCreateRequest(String contact, String deliveryAddress, List<ItemCreateRequest> items) {
        this.contact = contact;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
    }

    public List<ItemCreateRequest> getItems() {
        return items;
    }

    public Orders createOrder(Store store, Customer customer, List<Item> items) {
        return new Orders(deliveryAddress, contact, Status.WAITING_PAYMENT, store, customer, items);
    }


    static class ItemCreateRequest {

        private final Long productId;
        private final Integer quantity;

        public ItemCreateRequest(Long productId, Integer quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public Long getProductId() {
            return productId;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }

}
