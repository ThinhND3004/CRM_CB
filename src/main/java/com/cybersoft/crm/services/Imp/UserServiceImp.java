package com.cybersoft.crm.services.Imp;

import com.cybersoft.crm.dto.UserDTO;
import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserServiceImp  {
    RoleEntity getRoleByIdUser(int id);

    UserEntity getUserByEmail(String email);

    List<UserEntity> getAllUser();

    String checkRegister(UserDTO userDTO);

    boolean save(UserEntity user);
    boolean saveNewUserToDB(UserDTO userDTO);
}
