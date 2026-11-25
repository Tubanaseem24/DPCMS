package com.dpcms.repository;

import com.dpcms.model.RiskScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {
    Optional<RiskScore> findByUserUserId(Long userId);

    @Query("SELECT rs FROM RiskScore rs WHERE rs.riskLevel IN ('HIGH', 'CRITICAL') ORDER BY rs.totalScore DESC")
    List<RiskScore> findHighRiskUsers();
}