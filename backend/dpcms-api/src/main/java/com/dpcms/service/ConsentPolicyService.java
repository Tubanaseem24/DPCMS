package com.dpcms.service;

import com.dpcms.model.ConsentPolicy;
import com.dpcms.repository.ConsentPolicyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsentPolicyService {

    private final ConsentPolicyRepository policyRepository;

    public ConsentPolicyService(ConsentPolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<ConsentPolicy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public List<ConsentPolicy> getActivePolicies() {
        return policyRepository.findByIsActive(1);
    }

    public ConsentPolicy createPolicy(ConsentPolicy policy) {
        return policyRepository.save(policy);
    }

    public ConsentPolicy updatePolicy(Long policyId, ConsentPolicy updatedPolicy) {
        ConsentPolicy policy = policyRepository.findById(policyId)
            .orElseThrow(() -> new RuntimeException("Policy not found: " + policyId));
        policy.setTitle(updatedPolicy.getTitle());
        policy.setDescription(updatedPolicy.getDescription());
        policy.setVersion(updatedPolicy.getVersion());
        policy.setEffectiveDate(updatedPolicy.getEffectiveDate());
        policy.setExpiryDate(updatedPolicy.getExpiryDate());
        return policyRepository.save(policy);
    }

    public void deactivatePolicy(Long policyId) {
        ConsentPolicy policy = policyRepository.findById(policyId)
            .orElseThrow(() -> new RuntimeException("Policy not found: " + policyId));
        policy.setIsActive(0);
        policyRepository.save(policy);
    }
}