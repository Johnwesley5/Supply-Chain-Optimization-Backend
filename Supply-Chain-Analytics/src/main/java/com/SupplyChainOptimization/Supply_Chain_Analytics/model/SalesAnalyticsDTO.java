package com.SupplyChainOptimization.Supply_Chain_Analytics.model;

import java.time.LocalDate;
import java.util.Map;

public class SalesAnalyticsDTO {
    private Map<LocalDate, Integer> salesData;
    private Map<LocalDate, Double> revenueData;
    
    public SalesAnalyticsDTO() {
    }
    public SalesAnalyticsDTO(Map<LocalDate, Integer> salesData, Map<LocalDate, Double> revenueData) {
        this.salesData = salesData;
        this.revenueData = revenueData;
    }
    public Map<LocalDate, Integer> getSalesData() {
        return salesData;
    }
    public void setSalesData(Map<LocalDate, Integer> salesData) {
        this.salesData = salesData;
    }
    public Map<LocalDate, Double> getRevenueData() {
        return revenueData;
    }
    public void setRevenueData(Map<LocalDate, Double> revenueData) {
        this.revenueData = revenueData;
    }


}
