package com.SupplyChainOptimization.inventory_optimization.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.SupplyChainOptimization.inventory_optimization.model.QuantityUpdateRequest;

@FeignClient(name = "order-service", url = "http://localhost:8001")
public interface ProductServiceInterface {
    @PutMapping("/api/products/{productId}/quantity")
    void updateProductQuantity(@PathVariable Long productId, @RequestBody QuantityUpdateRequest request);
}


