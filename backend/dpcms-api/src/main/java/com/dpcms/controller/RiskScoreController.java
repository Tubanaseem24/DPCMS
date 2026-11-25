package com.dpcms.controller;

import com.dpcms.model.RiskScore;
import com.dpcms.service.RiskScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk")
@CrossOrigin(origins = "*")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    public RiskScoreController(RiskScoreService riskScoreService) {
        this.riskScoreService = riskScoreService;
    }

    @GetMapping
    public ResponseEntity<List<RiskScore>> getAllRiskScores() {
        return ResponseEntity.ok(riskScoreService.getAllRiskScores());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<RiskScore> getUserRiskScore(@PathVariable Long userId) {
        return riskScoreService.getUserRiskScore(userId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/high-risk")
    public ResponseEntity<List<RiskScore>> getHighRiskUsers() {
        return ResponseEntity.ok(riskScoreService.getHighRiskUsers());
    }
}