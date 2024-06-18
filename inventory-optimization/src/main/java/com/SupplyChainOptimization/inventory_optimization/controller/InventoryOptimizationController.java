package com.SupplyChainOptimization.inventory_optimization.controller;

import com.SupplyChainOptimization.inventory_optimization.service.InventoryOptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryOptimizationController {

    private final InventoryOptimizationService inventoryOptimizationService;

    @Autowired
    public InventoryOptimizationController(InventoryOptimizationService inventoryOptimizationService) {
        this.inventoryOptimizationService = inventoryOptimizationService;
    }

    @PostMapping("/optimize/{newStockQuantity}")
    public ResponseEntity<String> optimizeInventory(@PathVariable int newStockQuantity) {
        inventoryOptimizationService.optimizeInventory(newStockQuantity);
        return ResponseEntity.ok("Inventory optimized successfully.");
    }
}
