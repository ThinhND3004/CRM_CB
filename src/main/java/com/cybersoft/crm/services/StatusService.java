package com.cybersoft.crm.services;

import com.cybersoft.crm.entities.StatusEntity;
import com.cybersoft.crm.responsitory.StatusRepository;
import com.cybersoft.crm.services.Imp.StatusServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements StatusServiceImp {
    @Autowired
    private StatusRepository statusRepository;
    @Override
    public StatusEntity getById(int id) {
        StatusEntity status = statusRepository.getById(id);

        return status;
    }
}
