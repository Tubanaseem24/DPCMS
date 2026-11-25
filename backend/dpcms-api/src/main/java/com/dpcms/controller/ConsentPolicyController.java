package com.dpcms.controller;

import com.dpcms.model.ConsentPolicy;
import com.dpcms.service.ConsentPolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = "*")
public class ConsentPolicyController {

    private final ConsentPolicyService policyService;

    public ConsentPolicyController(ConsentPolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public ResponseEntity<List<ConsentPolicy>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping("/active")
    public ResponseEntity<List<ConsentPolicy>> getActivePolicies() {
        return ResponseEntity.ok(policyService.getActivePolicies());
    }

    @PostMapping
    public ResponseEntity<ConsentPolicy> createPolicy(@RequestBody ConsentPolicy policy) {
        return ResponseEntity.ok(policyService.createPolicy(policy));
    }

    @PutMapping("/{policyId}")
    public ResponseEntity<ConsentPolicy> updatePolicy(@PathVariable Long policyId,
                                                       @RequestBody ConsentPolicy policy) {
        return ResponseEntity.ok(policyService.updatePolicy(policyId, policy));
    }

    @PutMapping("/{policyId}/deactivate")
    public ResponseEntity<String> deactivatePolicy(@PathVariable Long policyId) {
        policyService.deactivatePolicy(policyId);
        return ResponseEntity.ok("Policy deactivated successfully");
    }
}