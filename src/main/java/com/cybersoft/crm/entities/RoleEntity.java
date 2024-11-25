package com.cybersoft.crm.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "roleEntity")
    private List<UserEntity> entityList;

    public RoleEntity(int id, String name, String description, List<UserEntity> entityList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.entityList = entityList;
    }

    public RoleEntity() {
        this.name = "";
        this.description = "";
        this.entityList = null;
    }

    public RoleEntity(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<UserEntity> entityList) {
        this.entityList = entityList;
    }
}
