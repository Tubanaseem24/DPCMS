package com.dpcms.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RISK_SCORES")
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCORE_ID")
    private Long scoreId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "TOTAL_SCORE")
    private Double totalScore = 0.0;

    @Column(name = "RISK_LEVEL")
    private String riskLevel = "LOW";

    @Column(name = "CRITICAL_CONSENTS")
    private Integer criticalConsents = 0;

    @Column(name = "HIGH_CONSENTS")
    private Integer highConsents = 0;

    @Column(name = "MEDIUM_CONSENTS")
    private Integer mediumConsents = 0;

    @Column(name = "LOW_CONSENTS")
    private Integer lowConsents = 0;

    @Column(name = "LAST_CALCULATED")
    private LocalDateTime lastCalculated;

    @PrePersist
    public void prePersist() {
        this.lastCalculated = LocalDateTime.now();
    }

    public Long getScoreId() { return scoreId; }
    public void setScoreId(Long scoreId) { this.scoreId = scoreId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Double getTotalScore() { return totalScore; }
    public void setTotalScore(Double totalScore) { this.totalScore = totalScore; }
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public Integer getCriticalConsents() { return criticalConsents; }
    public void setCriticalConsents(Integer criticalConsents) { this.criticalConsents = criticalConsents; }
    public Integer getHighConsents() { return highConsents; }
    public void setHighConsents(Integer highConsents) { this.highConsents = highConsents; }
    public Integer getMediumConsents() { return mediumConsents; }
    public void setMediumConsents(Integer mediumConsents) { this.mediumConsents = mediumConsents; }
    public Integer getLowConsents() { return lowConsents; }
    public void setLowConsents(Integer lowConsents) { this.lowConsents = lowConsents; }
    public LocalDateTime getLastCalculated() { return lastCalculated; }
    public void setLastCalculated(LocalDateTime lastCalculated) { this.lastCalculated = lastCalculated; }
}