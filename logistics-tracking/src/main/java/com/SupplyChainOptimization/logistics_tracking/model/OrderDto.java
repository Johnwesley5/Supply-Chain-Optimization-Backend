package com.SupplyChainOptimization.logistics_tracking.model;

import java.time.LocalDateTime;

public class OrderDto {
    private Long orderId;
    private Long productId;
    private LocalDateTime dateTime;
    private boolean shipped;
    private boolean outForDelivery;
    private boolean delivered;

  
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
