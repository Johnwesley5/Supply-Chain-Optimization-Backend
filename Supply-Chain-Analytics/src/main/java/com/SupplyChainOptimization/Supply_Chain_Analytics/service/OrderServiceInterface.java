package com.SupplyChainOptimization.Supply_Chain_Analytics.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.SupplyChainOptimization.Supply_Chain_Analytics.model.Order;
import com.SupplyChainOptimization.Supply_Chain_Analytics.model.Product;

import java.util.List;

@FeignClient(name = "order-service", url = "http://localhost:8001")
public interface OrderServiceInterface {


@GetMapping("/api/orders/all")
List<Order> getAllOrders();

@GetMapping("/api/products")
List<Product> getAllProducts();

@GetMapping("/api/products/{productId}")
Product getProductById(@PathVariable("productId") Long productId);
}