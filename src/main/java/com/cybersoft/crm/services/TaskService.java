package com.cybersoft.crm.services;

import com.cybersoft.crm.entities.TasksEntity;
import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.responsitory.TaskRepository;
import com.cybersoft.crm.services.Imp.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskServiceImp {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TasksEntity> getAllByUserId(UserEntity user) {
        List<TasksEntity> task = taskRepository.getAllByUserEntity(user);

        return task;


    }

    @Override
    public List<TasksEntity> getAllTask() {
        List<TasksEntity> tasksEntities = taskRepository.findAll();

        return tasksEntities;
    }
}
