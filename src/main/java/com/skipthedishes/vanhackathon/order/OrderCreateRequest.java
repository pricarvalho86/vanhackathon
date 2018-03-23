package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.order.models.Order;
import com.skipthedishes.vanhackathon.order.models.OrderItem;
import com.skipthedishes.vanhackathon.order.models.Status;
import com.skipthedishes.vanhackathon.store.Store;

import java.util.List;

public class OrderCreateRequest {

    private String deliveryAddress;
    private String contact;
    private Long storeId;
    private List<ItemCreateRequest> orderItems;

    public Order create(Customer customer, Store store, List<OrderItem> items) {
        final Order order = new Order(deliveryAddress, contact, Status.WAITING_PAYMENT, store, customer, items);
        items.forEach(item -> item.setOrder(order));
        return order;
    }

    public List<ItemCreateRequest> getOrderItems() {
        return orderItems;
    }

    static class ItemCreateRequest {

        private Long productId;
        private Integer quantity;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public void setOrderItems(List<ItemCreateRequest> orderItems) {
        this.orderItems = orderItems;
    }
}
