package com.SupplyChainOptimization.Supply_Chain_Analytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SupplyChainOptimization.Supply_Chain_Analytics.model.SalesAnalyticsDTO;
import com.SupplyChainOptimization.Supply_Chain_Analytics.service.AnalyticsService;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/lastTenDaysSalesAndRevenue")
    public ResponseEntity<SalesAnalyticsDTO> getLastTenDaysSalesAndRevenue() {
        SalesAnalyticsDTO analyticsData = analyticsService.getLastTenDaysSalesAndRevenue();
        return ResponseEntity.ok(analyticsData);
    }
}

