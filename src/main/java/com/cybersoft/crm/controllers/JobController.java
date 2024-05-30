package com.cybersoft.crm.controllers;

import com.cybersoft.crm.entities.JobsEntity;
import com.cybersoft.crm.services.Imp.JobServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    private static final String JOB_PAGE = "job";

    @Autowired
    private JobServiceImp jobServiceImp;

    @GetMapping("")
    public String jobPage(Model model)
    {
        String url = JOB_PAGE;
        List<JobsEntity> jobsEntityList = jobServiceImp.getAllJob();

        model.addAttribute("JOBS", jobsEntityList);
        return url;
    }

}
