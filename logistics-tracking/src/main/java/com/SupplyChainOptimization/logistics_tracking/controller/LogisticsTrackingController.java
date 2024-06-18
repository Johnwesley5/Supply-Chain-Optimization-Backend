package com.SupplyChainOptimization.logistics_tracking.controller;

import com.SupplyChainOptimization.logistics_tracking.service.LogisticsTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/track")
public class LogisticsTrackingController {

    private final LogisticsTrackingService logisticsTrackingService;

    @Autowired
    public LogisticsTrackingController(LogisticsTrackingService logisticsTrackingService) {
        this.logisticsTrackingService = logisticsTrackingService;
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<String> trackOrder(@PathVariable Long orderId) {
        String status = logisticsTrackingService.trackOrder(orderId);
        return ResponseEntity.ok(status);
    }
}
