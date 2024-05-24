package com.cybersoft.crm.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "statusEntity")
    private List<TasksEntity> tasksEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TasksEntity> getTasksEntities() {
        return tasksEntities;
    }

    public void setTasksEntities(List<TasksEntity> tasksEntities) {
        this.tasksEntities = tasksEntities;
    }
}
