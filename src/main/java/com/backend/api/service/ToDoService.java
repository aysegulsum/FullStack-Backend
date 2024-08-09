package com.backend.api.service;

import com.backend.api.data.ToDoRepository;
import com.backend.api.entity.ToDoEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    //@Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public boolean addToDo(ToDoEntity todo) {
        try {
            toDoRepository.save(todo);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<ToDoEntity> getAllData() {
        try {
            return toDoRepository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }
    public boolean delete(long id) {
        try {
            Optional<Optional<ToDoEntity>> optionalTodo = Optional.ofNullable(this.toDoRepository.findById(id));
            if (optionalTodo.isPresent()) {
                toDoRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateStart(long id, boolean bool) {
        try {
            Optional<ToDoEntity> temp = this.toDoRepository.findById(id);
            if (temp.isPresent()) {
                ToDoEntity toDoEntity = temp.get();
                toDoEntity.setStarted(bool);
                toDoRepository.save(toDoEntity);
                return true;
            }else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateComplete(long id, boolean bool) {
        try {
            Optional<ToDoEntity> temp = this.toDoRepository.findById(id);
            if (temp.isPresent()) {
                ToDoEntity toDoEntity = temp.get();
                toDoEntity.setCompleted(bool);
                toDoRepository.save(toDoEntity);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
