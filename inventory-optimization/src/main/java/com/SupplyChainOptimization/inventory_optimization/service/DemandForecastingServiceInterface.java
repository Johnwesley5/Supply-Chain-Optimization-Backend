package com.SupplyChainOptimization.inventory_optimization.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demand-forecasting-service", url = "http://localhost:8002")
public interface DemandForecastingServiceInterface {
    @GetMapping("/api/forecast/demanding-product")
    Long getDemandingProduct();
}

