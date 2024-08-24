package com.navneeth.orderservice.services;

import com.navneeth.orderservice.model.OrderRequest;
import com.navneeth.orderservice.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetailsById(long orderId);
}
