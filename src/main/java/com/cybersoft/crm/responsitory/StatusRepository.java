package com.cybersoft.crm.responsitory;

import com.cybersoft.crm.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

    StatusEntity getById(int id);
}
