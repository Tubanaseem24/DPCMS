package com.dpcms.controller;

import com.dpcms.model.DsrRequest;
import com.dpcms.service.DsrRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dsr")
@CrossOrigin(origins = "*")
public class DsrRequestController {

    private final DsrRequestService dsrService;

    public DsrRequestController(DsrRequestService dsrService) {
        this.dsrService = dsrService;
    }

    @GetMapping
    public ResponseEntity<List<DsrRequest>> getAllRequests() {
        return ResponseEntity.ok(dsrService.getAllRequests());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DsrRequest>> getUserRequests(@PathVariable Long userId) {
        return ResponseEntity.ok(dsrService.getUserRequests(userId));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<DsrRequest>> getPendingRequests() {
        return ResponseEntity.ok(dsrService.getPendingRequests());
    }

    @PostMapping("/submit")
    public ResponseEntity<DsrRequest> submitRequest(@RequestBody DsrRequest request) {
        return ResponseEntity.ok(dsrService.submitRequest(request));
    }

    @PutMapping("/{requestId}/status")
    public ResponseEntity<DsrRequest> updateStatus(
            @PathVariable Long requestId,
            @RequestParam String status,
            @RequestParam String handledBy) {
        return ResponseEntity.ok(dsrService.updateRequestStatus(requestId, status, handledBy));
    }
}