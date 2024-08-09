package com.backend.api.data;

import com.backend.api.entity.CategoryEntity;
import com.backend.api.entity.ToDoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @EntityGraph(attributePaths = "todos")
    List<CategoryEntity> findAll();
    CategoryEntity findById(int id);
    CategoryEntity save(CategoryEntity categoryEntity);
}
