package com.dpcms.repository;

import com.dpcms.model.DsrRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DsrRequestRepository extends JpaRepository<DsrRequest, Long> {
    List<DsrRequest> findByUserUserId(Long userId);
    List<DsrRequest> findByStatus(String status);
    List<DsrRequest> findByRequestType(String requestType);
}