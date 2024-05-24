package com.cybersoft.crm.services;

import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.responsitory.UserResponsitory;
import com.cybersoft.crm.services.Imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    private UserResponsitory userResponsitory;


    @Override
    public boolean checkLogin(String email, String password) {

        boolean check = false;

        UserEntity user = userResponsitory.getByEmail(email);

        if(user != null)
        {
            if(password.equals(user.getPassword()))
            {
                check = true;
            }
        }
        return check;
    }

    @Override
    public UserEntity getByEmail(String email) {

        UserEntity resutlUser = userResponsitory.getByEmail(email);

        return resutlUser;
    }




}
