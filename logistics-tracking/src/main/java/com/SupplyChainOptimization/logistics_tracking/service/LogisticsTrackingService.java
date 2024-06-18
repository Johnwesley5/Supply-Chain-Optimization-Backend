package com.SupplyChainOptimization.logistics_tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SupplyChainOptimization.logistics_tracking.model.OrderDto;

@Service
public class LogisticsTrackingService {

    private final OrderServiceInterface orderServiceInterface;

    @Autowired
    public LogisticsTrackingService(OrderServiceInterface orderServiceInterface) {
        this.orderServiceInterface = orderServiceInterface;
    }

    public String trackOrder(Long orderId) {
        OrderDto order = orderServiceInterface.getOrderById(orderId);
        if (order.isDelivered()) {
            return "Order delivered";
        } else if (order.isOutForDelivery()) {
            return "Your order is out for delivery";
        } else if (order.isShipped()) {
            return "Your order is shipped";
        } else {
            return "Order placed";
        }
    }
}
