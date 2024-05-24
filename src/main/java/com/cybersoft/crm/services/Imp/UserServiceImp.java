package com.cybersoft.crm.services.Imp;

import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceImp  {
    RoleEntity getRoleByIdUser(int id);

    UserEntity getUserByEmail(String email);
}
