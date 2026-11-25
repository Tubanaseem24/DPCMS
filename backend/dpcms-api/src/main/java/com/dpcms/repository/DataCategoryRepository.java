package com.dpcms.repository;

import com.dpcms.model.DataCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DataCategoryRepository extends JpaRepository<DataCategory, Long> {
    List<DataCategory> findBySensitivity(String sensitivity);
    boolean existsByName(String name);
}