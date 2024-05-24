package com.cybersoft.crm.controllers;

import com.cybersoft.crm.entities.TasksEntity;
import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.responsitory.UserResponsitory;
import com.cybersoft.crm.services.Imp.JobServiceImp;
import com.cybersoft.crm.services.Imp.TaskServiceImp;
import com.cybersoft.crm.services.Imp.UserServiceImp;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private TaskServiceImp taskServiceImp;

    @Autowired
    private JobServiceImp jobServiceImp;

    @GetMapping("")
    public String profile(Model model, HttpServletRequest request)
    {
        String email = "";
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies)
        {
            if(cookie.getName().equals("email"))
            {
                email = cookie.getValue();
                break;
            }
        }
        UserEntity user = userServiceImp.getUserByEmail(email);

        model.addAttribute("user", user);

        List<TasksEntity> tasks =  taskServiceImp.getAllByUserId(user);

        model.addAttribute("tasks", tasks);



        return "profile";
    }

}
