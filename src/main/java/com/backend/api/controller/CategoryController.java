package com.backend.api.controller;

import com.backend.api.entity.CategoryEntity;
import com.backend.api.entity.ToDoEntity;
import com.backend.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam String name) {

        CategoryEntity category = new CategoryEntity(name);

        if (categoryService.add(category)) {
            return ResponseEntity.ok("Category added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Category could not added!");
        }
    }


    @GetMapping("/getcategories")
    public List<CategoryEntity> getAllEntities() {
        return categoryService.getAllData();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable long id) {

        if (categoryService.delete(id)) {
            return ResponseEntity.ok("Delete successful");
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Category could not be deleted!");
        }
    }

}
