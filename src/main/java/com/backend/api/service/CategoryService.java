package com.backend.api.service;

import com.backend.api.data.CategoryRepository;
import com.backend.api.entity.CategoryEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryEntity findCategoryById(int id){
        return repository.findById(id);
    }
}
