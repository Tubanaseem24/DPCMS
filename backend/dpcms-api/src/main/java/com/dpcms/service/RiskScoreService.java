package com.dpcms.service;

import com.dpcms.model.RiskScore;
import com.dpcms.repository.RiskScoreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;

    public RiskScoreService(RiskScoreRepository riskScoreRepository) {
        this.riskScoreRepository = riskScoreRepository;
    }

    public Optional<RiskScore> getUserRiskScore(Long userId) {
        return riskScoreRepository.findByUserUserId(userId);
    }

    public List<RiskScore> getHighRiskUsers() {
        return riskScoreRepository.findHighRiskUsers();
    }

    public List<RiskScore> getAllRiskScores() {
        return riskScoreRepository.findAll();
    }
}