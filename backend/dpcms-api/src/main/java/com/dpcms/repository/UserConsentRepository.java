package com.dpcms.repository;

import com.dpcms.model.UserConsent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserConsentRepository extends JpaRepository<UserConsent, Long> {

    List<UserConsent> findByUserUserId(Long userId);

    @Query("SELECT uc FROM UserConsent uc WHERE uc.user.userId = :userId AND uc.status = 'GRANTED'")
    List<UserConsent> findActiveConsentsByUserId(@Param("userId") Long userId);

    @Query("SELECT uc FROM UserConsent uc WHERE uc.status = 'GRANTED'")
    List<UserConsent> findAllActiveConsents();

    List<UserConsent> findByStatus(String status);
}