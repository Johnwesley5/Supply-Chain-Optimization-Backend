
package com.supplyChainOptimization.demand_forecasting.model;

import java.time.LocalDateTime;

public class OrderDto {

    private Long orderId;
    private ProductDto product;
    private LocalDateTime dateTime;
    private boolean shipped;
    private boolean outForDelivery;
    private boolean delivered;

    public OrderDto() {
    }

    public OrderDto(Long orderId, ProductDto product, LocalDateTime dateTime, boolean shipped, boolean outForDelivery, boolean delivered) {
        this.orderId = orderId;
        this.product = product;
        this.dateTime = dateTime;
        this.shipped = shipped;
        this.outForDelivery = outForDelivery;
        this.delivered = delivered;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
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

    public static class ProductDto {
        private Long productId;

        public ProductDto() {
        }

        public ProductDto(Long productId) {
            this.productId = productId;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }
    }
}
