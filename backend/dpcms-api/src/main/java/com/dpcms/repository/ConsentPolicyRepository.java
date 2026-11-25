package com.dpcms.repository;

import com.dpcms.model.ConsentPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConsentPolicyRepository extends JpaRepository<ConsentPolicy, Long> {
    List<ConsentPolicy> findByIsActive(Integer isActive);
    boolean existsByTitleAndVersion(String title, String version);
}