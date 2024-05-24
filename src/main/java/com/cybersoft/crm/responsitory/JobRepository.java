package com.cybersoft.crm.responsitory;

import com.cybersoft.crm.entities.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobsEntity, Integer> {

    JobsEntity getById(int id);

}
