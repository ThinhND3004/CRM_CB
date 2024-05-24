package com.cybersoft.crm.services;

import com.cybersoft.crm.entities.JobsEntity;
import com.cybersoft.crm.responsitory.JobRepository;
import com.cybersoft.crm.services.Imp.JobServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService implements JobServiceImp {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public JobsEntity getById(int id) {
        JobsEntity job = jobRepository.getById(id);

        return job;
    }
}