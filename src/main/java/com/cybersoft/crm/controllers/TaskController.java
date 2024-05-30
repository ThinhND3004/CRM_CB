package com.cybersoft.crm.controllers;

import com.cybersoft.crm.entities.TasksEntity;
import com.cybersoft.crm.services.Imp.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    private static final String TASK_PAGE = "task";

    @Autowired
    private TaskServiceImp taskServiceImp;


    @GetMapping("")
    public String taskPage(Model model)
    {
        String url = TASK_PAGE;
        List<TasksEntity> tasksEntities = taskServiceImp.getAllTask();

        model.addAttribute("TASKS", tasksEntities);


        return url;
    }


}
