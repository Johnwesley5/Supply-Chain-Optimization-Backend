package com.supplyChainOptimization.demand_forecasting.service;

import com.supplyChainOptimization.demand_forecasting.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DemandForecastingService {

    private final OrderServiceInterface orderServiceInterface;

    @Autowired
    public DemandForecastingService(OrderServiceInterface orderServiceInterface) {
        this.orderServiceInterface = orderServiceInterface;
    }

    public List<OrderDto> getAllOrders() {
        return orderServiceInterface.getAllOrders();
    }

    public Long getDemandingProduct() {
        List<OrderDto> orders = getAllOrders();

        Map<Long, Long> productCountMap = orders.stream()
            .filter(order -> order.getProduct() != null)
            .map(order -> order.getProduct().getProductId())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return productCountMap.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }
}
