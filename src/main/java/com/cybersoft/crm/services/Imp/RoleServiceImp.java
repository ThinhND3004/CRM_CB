package com.cybersoft.crm.services.Imp;

import com.cybersoft.crm.entities.RoleEntity;

import java.util.List;

public interface RoleServiceImp {
    List<RoleEntity> getAllRoles();

    String save(RoleEntity roleEntity);

    RoleEntity getById(int id);

    String delete(RoleEntity role);

}
