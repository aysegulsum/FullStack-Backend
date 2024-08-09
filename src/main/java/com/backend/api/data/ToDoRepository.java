package com.backend.api.data;

import com.backend.api.entity.ToDoEntity;
import com.backend.api.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
    @EntityGraph(attributePaths = "category")
    List<ToDoEntity> findAll();

    @Transactional
    ToDoEntity save(ToDoEntity toDoEntity);
}
