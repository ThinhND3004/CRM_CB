package com.cybersoft.crm.services.Imp;

import com.cybersoft.crm.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public interface LoginServiceImp {
    boolean checkLogin(String email, String password);
    UserEntity getByEmail(String email);
}
