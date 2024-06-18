package com.supplyChainOptimization.demand_forecasting.model;

// package com.supplyChainOptimization.demand_forecasting.util;

import com.supplyChainOptimization.demand_forecasting.model.OrderDto;

public class OrderMapper {

    public static OrderDto toDto(OrderDto orderDto) {
        OrderDto.ProductDto productDto = new OrderDto.ProductDto(orderDto.getProduct().getProductId());

        return new OrderDto(
            orderDto.getOrderId(),
            productDto,
            orderDto.getDateTime(),
            orderDto.isShipped(),
            orderDto.isOutForDelivery(),
            orderDto.isDelivered()
        );
    }
}
