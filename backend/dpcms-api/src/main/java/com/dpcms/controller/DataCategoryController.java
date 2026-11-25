package com.dpcms.controller;

import com.dpcms.model.DataCategory;
import com.dpcms.service.DataCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class DataCategoryController {

    private final DataCategoryService categoryService;

    public DataCategoryController(DataCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<DataCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/sensitivity/{sensitivity}")
    public ResponseEntity<List<DataCategory>> getBySensitivity(@PathVariable String sensitivity) {
        return ResponseEntity.ok(categoryService.getCategoriesBySensitivity(sensitivity));
    }

    @PostMapping
    public ResponseEntity<DataCategory> createCategory(@RequestBody DataCategory category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<DataCategory> updateCategory(@PathVariable Long categoryId,
                                                        @RequestBody DataCategory category) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, category));
    }
}