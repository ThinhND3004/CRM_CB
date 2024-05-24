package com.cybersoft.crm.services.Imp;

import com.cybersoft.crm.entities.TasksEntity;
import com.cybersoft.crm.entities.UserEntity;

import java.util.List;

public interface TaskServiceImp {
    List<TasksEntity> getAllByUserId(UserEntity user);

}
