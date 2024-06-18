package com.supplyChainOptimization.orders_service.model;

public class OrderStatusUpdateRequest {
    private boolean shipped;
    private boolean outForDelivery;
    private boolean delivered;

    // Getters and Setters
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

