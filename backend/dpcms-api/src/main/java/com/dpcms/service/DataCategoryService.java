package com.dpcms.service;

import com.dpcms.model.DataCategory;
import com.dpcms.repository.DataCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataCategoryService {

    private final DataCategoryRepository categoryRepository;

    public DataCategoryService(DataCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<DataCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<DataCategory> getCategoriesBySensitivity(String sensitivity) {
        return categoryRepository.findBySensitivity(sensitivity);
    }

    public DataCategory createCategory(DataCategory category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new RuntimeException("Category already exists: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    public DataCategory updateCategory(Long categoryId, DataCategory updatedCategory) {
        DataCategory category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found: " + categoryId));
        category.setName(updatedCategory.getName());
        category.setDescription(updatedCategory.getDescription());
        category.setSensitivity(updatedCategory.getSensitivity());
        return categoryRepository.save(category);
    }
}