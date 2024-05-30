package com.cybersoft.crm.services;

import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.responsitory.RoleRepository;
import com.cybersoft.crm.responsitory.UserResponsitory;
import com.cybersoft.crm.services.Imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements RoleServiceImp {

    private static final String ROLE_IN_USE_MESSAGE = "Cannot remove this role!";
    private static final String ROLE_DUPLICATE_MESSAGE = "This role has been used!";


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserResponsitory userResponsitory;


    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public String save(RoleEntity roleEntity)
    {
        String result = null;
        boolean check = false;

        List<RoleEntity> roles = roleRepository.findAll();

        for(RoleEntity role : roles)
        {
            if(role.getName().equals(roleEntity.getName()))
            {
                check = true;
                break;
            }
        }

        if(check)
        {
           result =  ROLE_DUPLICATE_MESSAGE;
        } else
        {
            RoleEntity role = roleRepository.save(roleEntity);
        }
        return result;
    }

    @Override
    public RoleEntity getById(int id) {
        RoleEntity roleEntity = roleRepository.getById(id);

        return roleEntity;
    }

    @Override
    public String delete(RoleEntity roleEntity) {
        boolean check = false;
        String result = "";

        List<UserEntity> users = userResponsitory.findAll();

        for(UserEntity user : users)
        {
            if(user.getRoleEntity().getName().equals(roleEntity.getName()))
            {
                check = true;
                break;
            }
        }

        if(check)
        {
            result = ROLE_IN_USE_MESSAGE;
        } else
        {
            RoleEntity role = roleRepository.deleteById(roleEntity.getId());
        }

        return result;
    }


}
