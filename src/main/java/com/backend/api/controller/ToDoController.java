package com.backend.api.controller;

import com.backend.api.entity.CategoryEntity;
import com.backend.api.entity.ToDoEntity;
import com.backend.api.service.CategoryService;
import com.backend.api.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ToDo")
public class ToDoController {

    private final ToDoService myService;
    private final CategoryService categoryService;

    //@Autowired
    public ToDoController(ToDoService myService, CategoryService categoryService) {
        this.myService = myService;

        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToDO(@RequestParam String description,
                                          @RequestParam boolean isStarted,
                                          @RequestParam boolean isCompleted,
                                          @RequestParam int categoryId) {

        CategoryEntity category = categoryService.findCategoryById(categoryId);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid category ID.");
        } else {
            ToDoEntity todo = new ToDoEntity(description, isStarted, isCompleted, category);
            if (myService.addToDo(todo)) {
                return ResponseEntity.ok("ToDo item added successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ToDo item could not added!");
            }
        }

    }

    @GetMapping("/list")
    public List<ToDoEntity> getAllEntities() {
        return myService.getAllData();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable long id) {//, @RequestBody Map<String, String> request){

        if (myService.delete(id)) {
            return ResponseEntity.ok("Delete successful");
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ToDo could not be deleted!");
        }
    }

    @PutMapping("/updatestart/{id}")
    public ResponseEntity<String> updateStart(@PathVariable long id, @RequestBody Map<String, String> request) {
        Boolean bool = Boolean.valueOf(request.get("str"));
        if (myService.updateStart(id, bool)) {
            return ResponseEntity.ok("Updated successfuly");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ToDo could not be updated!");
        }

    }

    @PutMapping("/updatecomplete/{id}")
    public ResponseEntity<String> updateComplete(@PathVariable long id, @RequestBody Map<String, String> request) {
        Boolean bool = Boolean.valueOf(request.get("str"));
        if (myService.updateComplete(id, bool)) {
            return ResponseEntity.ok("Updated successfuly");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ToDo could not be updated!");
        }
    }
}
