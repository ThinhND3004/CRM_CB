package com.cybersoft.crm.services.Imp;

import com.cybersoft.crm.entities.JobsEntity;

import java.util.List;

public interface JobServiceImp {

    JobsEntity getById(int id);

    List<JobsEntity> getAllJob();

}
