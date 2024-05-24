package com.cybersoft.crm.responsitory;

import com.cybersoft.crm.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsitory extends JpaRepository<UserEntity, Integer> {
    UserEntity getByEmail(String email);

    UserEntity getById(int id);

}
