// 
package com.supplyChainOptimization.orders_service.service;

import com.supplyChainOptimization.orders_service.model.Order;
import com.supplyChainOptimization.orders_service.model.OrderStatusUpdateRequest;
import com.supplyChainOptimization.orders_service.model.Product;
import com.supplyChainOptimization.orders_service.repository.OrderRepository;
import com.supplyChainOptimization.orders_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public boolean placeOrder(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (product.getQuantity() > 0) {
                product.setQuantity(product.getQuantity() - 1);
                productRepository.save(product);
                Order order = new Order(product, LocalDateTime.now(), false, false, false);
                orderRepository.save(order);
                return true;
            }
        }
        return false;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Transactional
    public Optional<Order> updateOrderStatus(Long orderId, OrderStatusUpdateRequest request) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setShipped(request.isShipped());
            order.setOutForDelivery(request.isOutForDelivery());
            order.setDelivered(request.isDelivered());
            orderRepository.save(order);
            return Optional.of(order);
        } else {
            return Optional.empty();
        }
    }
}
