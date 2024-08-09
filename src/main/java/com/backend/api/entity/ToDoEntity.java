package com.backend.api.entity;

import jakarta.persistence.*;


@Entity
@Table(name="todotable")
public class ToDoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "description")
    private String description;

    @Column(name = "isstarted")
    private boolean isStarted;

    @Column(name = "iscompleted")
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public ToDoEntity() {
    }

    public ToDoEntity(String description) {
        this.description = description;
    }

    public ToDoEntity(String description, boolean isStarted, boolean isCompleted) {
        this.description = description;
        this.isStarted = isStarted;
        this.isCompleted = isCompleted;
    }

    public ToDoEntity(String description, boolean isStarted, boolean isCompleted, CategoryEntity category) {
        this.id = id;
        this.description = description;
        this.isStarted = isStarted;
        this.isCompleted = isCompleted;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
