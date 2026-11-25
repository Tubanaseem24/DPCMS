package com.dpcms.controller;

import com.dpcms.model.UserConsent;
import com.dpcms.service.UserConsentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consents")
@CrossOrigin(origins = "*")
public class UserConsentController {

    private final UserConsentService consentService;

    public UserConsentController(UserConsentService consentService) {
        this.consentService = consentService;
    }

    @GetMapping
    public ResponseEntity<List<UserConsent>> getAllConsents() {
        return ResponseEntity.ok(consentService.getAllConsents());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserConsent>> getUserConsents(@PathVariable Long userId) {
        return ResponseEntity.ok(consentService.getUserConsents(userId));
    }

    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<UserConsent>> getActiveConsents(@PathVariable Long userId) {
        return ResponseEntity.ok(consentService.getActiveConsents(userId));
    }

    @GetMapping("/active")
    public ResponseEntity<List<UserConsent>> getAllActiveConsents() {
        return ResponseEntity.ok(consentService.getAllActiveConsents());
    }

    @PostMapping("/grant")
    public ResponseEntity<UserConsent> grantConsent(@RequestBody UserConsent consent) {
        return ResponseEntity.ok(consentService.grantConsent(consent));
    }

    @PutMapping("/{consentId}/withdraw")
    public ResponseEntity<UserConsent> withdrawConsent(@PathVariable Long consentId) {
        return ResponseEntity.ok(consentService.withdrawConsent(consentId));
    }

    @PostMapping("/deny")
    public ResponseEntity<UserConsent> denyConsent(@RequestBody UserConsent consent) {
        return ResponseEntity.ok(consentService.denyConsent(consent));
    }
}