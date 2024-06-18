

package com.supplyChainOptimization.demand_forecasting.controller;

import com.supplyChainOptimization.demand_forecasting.model.OrderDto;
import com.supplyChainOptimization.demand_forecasting.model.OrderMapper;
import com.supplyChainOptimization.demand_forecasting.service.DemandForecastingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/forecast")
public class DemandForecastingController {

    private final DemandForecastingService demandForecastingService;

    @Autowired
    public DemandForecastingController(DemandForecastingService demandForecastingService) {
        this.demandForecastingService = demandForecastingService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = demandForecastingService.getAllOrders();
        List<OrderDto> orderDtos = orders.stream()
                                         .map(OrderMapper::toDto)
                                         .collect(Collectors.toList());
        return ResponseEntity.ok(orderDtos);
    }

    @GetMapping("/demanding-product")
    public ResponseEntity<Long> getDemandingProduct() {
        Long demandingProductId = demandForecastingService.getDemandingProduct();
        return ResponseEntity.ok(demandingProductId);
    }
}
