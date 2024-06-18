package com.SupplyChainOptimization.Supply_Chain_Analytics.model;

import java.time.LocalDateTime;

public class Order {

    private Long orderId;
    private Long productId;
    private LocalDateTime dateTime;
    private boolean shipped;
    private Product product;
    private boolean outForDelivery;
    private boolean delivered;
    
    public Order() {
    }

    public Order(Long orderId, Long productId, LocalDateTime dateTime, boolean shipped, Product product,
            boolean outForDelivery, boolean delivered) {
        this.orderId = orderId;
        this.productId = productId;
        this.dateTime = dateTime;
        this.shipped = shipped;
        this.product = product;
        this.outForDelivery = outForDelivery;
        this.delivered = delivered;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
