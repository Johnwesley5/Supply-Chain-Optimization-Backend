package com.SupplyChainOptimization.inventory_optimization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SupplyChainOptimization.inventory_optimization.model.QuantityUpdateRequest;

@Service
public class InventoryOptimizationService {

    private final DemandForecastingServiceInterface demandForecastingServiceInterface;
    private final ProductServiceInterface productServiceInterface;

    @Autowired
    public InventoryOptimizationService(DemandForecastingServiceInterface demandForecastingServiceInterface, ProductServiceInterface productServiceInterface) {
        this.demandForecastingServiceInterface = demandForecastingServiceInterface;
        this.productServiceInterface = productServiceInterface;
    }

    public void optimizeInventory(int newStockQuantity) {
        Long demandingProductId = demandForecastingServiceInterface.getDemandingProduct();
        if (demandingProductId != null) {
            QuantityUpdateRequest request = new QuantityUpdateRequest();
            request.setQuantity(newStockQuantity);
            productServiceInterface.updateProductQuantity(demandingProductId, request);
        }
    }
}
