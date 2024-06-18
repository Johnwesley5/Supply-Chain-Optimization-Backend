package com.SupplyChainOptimization.Supply_Chain_Analytics.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.SupplyChainOptimization.Supply_Chain_Analytics.model.Order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SupplyChainOptimization.Supply_Chain_Analytics.model.SalesAnalyticsDTO;


@Service
public class AnalyticsService {

    @Autowired
    private OrderServiceInterface orderService;

    public SalesAnalyticsDTO getLastTenDaysSalesAndRevenue() {
        LocalDate today = LocalDate.now();
        LocalDate tenDaysAgo = today.minusDays(9); // Last 10 days

        List<Order> orders = orderService.getAllOrders();
        Map<LocalDate, Integer> salesData = new HashMap<>();
        Map<LocalDate, Double> revenueData = new HashMap<>();

        // Initialize salesData and revenueData maps with zeros for the last 10 days
        for (LocalDate date = tenDaysAgo; date.isBefore(today.plusDays(1)); date = date.plusDays(1)) {
            salesData.put(date, 0);
            revenueData.put(date, 0.0);
        }

        // Iterate through orders to calculate sales and revenue for each day
        for (Order order : orders) {
            LocalDate orderDate = order.getDateTime().toLocalDate();
            if (orderDate.isAfter(tenDaysAgo.minusDays(1)) && orderDate.isBefore(today.plusDays(1))) {
                // Update sales count for the order date
                salesData.put(orderDate, salesData.getOrDefault(orderDate, 0) + 1);
                
                // Update revenue for the order date
                double orderRevenue = order.getProduct().getPrice();
                revenueData.put(orderDate, revenueData.getOrDefault(orderDate, 0.0) + orderRevenue);
            }
        }

        SalesAnalyticsDTO analyticsDTO = new SalesAnalyticsDTO();
        analyticsDTO.setSalesData(salesData);
        analyticsDTO.setRevenueData(revenueData);

        return analyticsDTO;
    }
}

