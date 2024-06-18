package com.supplyChainOptimization.demand_forecasting.service;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.supplyChainOptimization.demand_forecasting.model.OrderDto;

@FeignClient(name = "order-service", url = "http://localhost:8001")
public interface OrderServiceInterface {

    @GetMapping("/api/orders/all")
    List<OrderDto> getAllOrders();
}
