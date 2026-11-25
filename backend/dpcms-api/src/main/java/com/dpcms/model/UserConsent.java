package com.dpcms.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_CONSENTS")
public class UserConsent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSENT_ID")
    private Long consentId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "POLICY_ID", nullable = false)
    private ConsentPolicy policy;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private DataCategory category;

    @Column(name = "STATUS")
    private String status = "GRANTED";

    @Column(name = "GRANTED_AT")
    private LocalDateTime grantedAt;

    @Column(name = "WITHDRAWN_AT")
    private LocalDateTime withdrawnAt;

    @Column(name = "EXPIRY_DATE")
    private LocalDate expiryDate;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "CONSENT_METHOD")
    private String consentMethod;

    @PrePersist
    public void prePersist() {
        this.grantedAt = LocalDateTime.now();
    }

    public Long getConsentId() { return consentId; }
    public void setConsentId(Long consentId) { this.consentId = consentId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public ConsentPolicy getPolicy() { return policy; }
    public void setPolicy(ConsentPolicy policy) { this.policy = policy; }
    public DataCategory getCategory() { return category; }
    public void setCategory(DataCategory category) { this.category = category; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getGrantedAt() { return grantedAt; }
    public void setGrantedAt(LocalDateTime grantedAt) { this.grantedAt = grantedAt; }
    public LocalDateTime getWithdrawnAt() { return withdrawnAt; }
    public void setWithdrawnAt(LocalDateTime withdrawnAt) { this.withdrawnAt = withdrawnAt; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public String getConsentMethod() { return consentMethod; }
    public void setConsentMethod(String consentMethod) { this.consentMethod = consentMethod; }
}