package com.cybersoft.crm.responsitory;

import com.cybersoft.crm.entities.TasksEntity;
import com.cybersoft.crm.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TasksEntity, Integer> {

    List<TasksEntity> getAllByUserEntity(UserEntity user);

}
