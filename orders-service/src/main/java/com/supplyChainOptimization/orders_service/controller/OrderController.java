
package com.supplyChainOptimization.orders_service.controller;

import com.supplyChainOptimization.orders_service.model.Order;
import com.supplyChainOptimization.orders_service.model.OrderStatusUpdateRequest;
import com.supplyChainOptimization.orders_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder/{productId}")
    public ResponseEntity<String> placeOrder(@PathVariable Long productId) {
        boolean success = orderService.placeOrder(productId);
        if (success) {
            return ResponseEntity.ok("Order placed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to place order. Product may not be available.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> order = orderService.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatusUpdateRequest request) {
        Optional<Order> updatedOrder = orderService.updateOrderStatus(orderId, request);
        return updatedOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
