package com.cybersoft.crm.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "jobs")
public class JobsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private String start_date;
    @Column(name = "end_date")
    private String end_date;
    @OneToMany(mappedBy = "jobsEntity")
    private List<TasksEntity> tasksEntities;

    public List<TasksEntity> getTasksEntities() {
        return tasksEntities;
    }

    public void setTasksEntities(List<TasksEntity> tasksEntities) {
        this.tasksEntities = tasksEntities;
    }

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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
