package com.dpcms.service;

import com.dpcms.model.DsrRequest;
import com.dpcms.repository.DsrRequestRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DsrRequestService {

    private final DsrRequestRepository dsrRepository;

    public DsrRequestService(DsrRequestRepository dsrRepository) {
        this.dsrRepository = dsrRepository;
    }

    public List<DsrRequest> getAllRequests() {
        return dsrRepository.findAll();
    }

    public List<DsrRequest> getUserRequests(Long userId) {
        return dsrRepository.findByUserUserId(userId);
    }

    public List<DsrRequest> getPendingRequests() {
        return dsrRepository.findByStatus("PENDING");
    }

    public DsrRequest submitRequest(DsrRequest request) {
        request.setStatus("PENDING");
        return dsrRepository.save(request);
    }

    public DsrRequest updateRequestStatus(Long requestId, String status, String handledBy) {
        DsrRequest request = dsrRepository.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Request not found: " + requestId));
        request.setStatus(status);
        request.setHandledBy(handledBy);
        if (status.equals("COMPLETED") || status.equals("REJECTED")) {
            request.setResolvedAt(LocalDateTime.now());
        }
        return dsrRepository.save(request);
    }
}