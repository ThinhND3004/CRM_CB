package com.cybersoft.crm.services;

import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.responsitory.RoleRepository;
import com.cybersoft.crm.services.Imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements RoleServiceImp {
    @Autowired
    private RoleRepository roleRepository;



    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }


}
