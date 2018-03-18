package com.skipthedishes.vanhackathon.order;

import com.skipthedishes.vanhackathon.customer.Customer;
import com.skipthedishes.vanhackathon.order.models.OrderItem;
import com.skipthedishes.vanhackathon.order.models.Order;
import com.skipthedishes.vanhackathon.order.models.Status;
import com.skipthedishes.vanhackathon.store.Store;

import java.util.List;

/*
{
	"id": 0,
	"date": "2018-03-18T19:30:48.181Z",
	"customerId": 0,
	"deliveryAddress": "string",
	"contact": "string",
	"storeId": 0,
	"orderItems": [{
		"id": 0,
		"orderId": 0,
		"productId": 0,
		"product": {
			"id": 0,
			"storeId": 0,
			"name": "string",
			"description": "string",
			"price": 0
		},
		"price": 0,
		"quantity": 0,
		"total": 0
	}],
	"total": 0,
	"status": "string",
	"lastUpdate": "2018-03-18T19:30:48.181Z"
}
*/

public class OrderCreateRequest {

    private final String deliveryAddress;
    private final String contact;
    private final Long storeId;
    private final List<ItemCreateRequest> orderItems;

    public OrderCreateRequest(String deliveryAddress, String contact, Long storeId, List<ItemCreateRequest> orderItems) {
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.storeId = storeId;
        this.orderItems = orderItems;
    }

    public Order create(Customer customer, Store store, List<OrderItem> orderItems) {
        return new Order(deliveryAddress, contact, Status.WAITING_PAYMENT, store, customer, orderItems);
    }

    public List<ItemCreateRequest> getOrderItems() {
        return orderItems;
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
