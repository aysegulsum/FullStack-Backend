package com.backend.api.service;

import com.backend.api.data.CategoryRepository;
import com.backend.api.entity.CategoryEntity;
import com.backend.api.entity.ToDoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity findCategoryById(int id){
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> getAllData() {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }
    public boolean add(CategoryEntity category){
        try{
            categoryRepository.save(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(long id) {
        try {
            Optional<Optional<CategoryEntity>> optionalTodo = Optional.ofNullable(this.categoryRepository.findById(id));
            if (optionalTodo.isPresent()) {
                categoryRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
