package com.dpcms.service;

import com.dpcms.model.UserConsent;
import com.dpcms.repository.UserConsentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserConsentService {

    private final UserConsentRepository consentRepository;

    public UserConsentService(UserConsentRepository consentRepository) {
        this.consentRepository = consentRepository;
    }

    public List<UserConsent> getAllConsents() {
        return consentRepository.findAll();
    }

    public List<UserConsent> getUserConsents(Long userId) {
        return consentRepository.findByUserUserId(userId);
    }

    public List<UserConsent> getActiveConsents(Long userId) {
        return consentRepository.findActiveConsentsByUserId(userId);
    }

    public List<UserConsent> getAllActiveConsents() {
        return consentRepository.findAllActiveConsents();
    }

    public UserConsent grantConsent(UserConsent consent) {
        consent.setStatus("GRANTED");
        return consentRepository.save(consent);
    }

    public UserConsent withdrawConsent(Long consentId) {
        UserConsent consent = consentRepository.findById(consentId)
            .orElseThrow(() -> new RuntimeException("Consent not found: " + consentId));
        consent.setStatus("WITHDRAWN");
        consent.setWithdrawnAt(LocalDateTime.now());
        return consentRepository.save(consent);
    }

    public UserConsent denyConsent(UserConsent consent) {
        consent.setStatus("DENIED");
        return consentRepository.save(consent);
    }
}