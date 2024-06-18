package com.SupplyChainOptimization.logistics_tracking.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.SupplyChainOptimization.logistics_tracking.model.OrderDto;

@FeignClient(name = "order-service", url = "http://localhost:8001")
public interface OrderServiceInterface {
    @GetMapping("/api/orders/{orderId}")
    OrderDto getOrderById(@PathVariable Long orderId);
}

