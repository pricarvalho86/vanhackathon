package com.skipthedishes.vanhackathon.order;

//id	integer($int64)
//date	string($date-time)
//customerId	integer($int64)
//deliveryAddress*	string
//contact*	string
//storeId*	integer($int64)
//orderItems*	[ OrderItem{
//                        id	integer($int64)
//                        orderId*	integer($int64)
//                        productId*	integer($int64)
//                        product	Product{
//                          id	integer($int64)
//                          storeId	integer($int64)
//                          name	string
//                          description	string
//                          price	number($double)
//                        }
//                        price*	number($double)
//                        quantity*	integer($int64)
//                        total	number($double)
//                }]
//total	number($double)
//status*	string
//lastUpdate	string($date-time)

public class OrderCreateRequest {

    private final String contact;
    private final Integer storeId;
    private final String status;
    private final Integer productId;

    public OrderCreateRequest(String contact, Integer storeId, String status, Integer productId) {
        this.contact = contact;
        this.storeId = storeId;
        this.status = status;
        this.productId = productId;
    }

}

