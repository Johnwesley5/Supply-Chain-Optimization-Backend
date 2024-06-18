package com.supplyChainOptimization.orders_service.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private LocalDateTime dateTime;

    private boolean shipped;
    private boolean outForDelivery;
    private boolean delivered;

    // Constructors
    public Order() {
    }

    public Order(Product product, LocalDateTime dateTime, boolean shipped, boolean outForDelivery, boolean delivered) {
        this.product = product;
        this.dateTime = dateTime;
        this.shipped = shipped;
        this.outForDelivery = outForDelivery;
        this.delivered = delivered;
    }

    // Getters and Setters
    public Long getorderId() {
        return orderId;
    }

    public void setId(Long id) {
        this.orderId = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public boolean isOutForDelivery() {
        return outForDelivery;
    }

    public void setOutForDelivery(boolean outForDelivery) {
        this.outForDelivery = outForDelivery;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}

