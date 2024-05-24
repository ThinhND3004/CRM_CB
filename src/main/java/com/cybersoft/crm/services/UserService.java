package com.cybersoft.crm.services;

import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.responsitory.UserResponsitory;
import com.cybersoft.crm.services.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserResponsitory userResponsitory;
    @Override
    public RoleEntity getRoleByIdUser(int id) {
        UserEntity user = userResponsitory.getById(id);

        RoleEntity roleOfUser = user.getRoleEntity();

        return roleOfUser;
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        UserEntity user =  userResponsitory.getByEmail(email);
        return user;
    }


}
