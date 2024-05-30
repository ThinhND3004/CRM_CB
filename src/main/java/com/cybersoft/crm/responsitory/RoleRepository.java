package com.cybersoft.crm.responsitory;

import com.cybersoft.crm.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity getById(int id);

    RoleEntity deleteById(int id);
}
