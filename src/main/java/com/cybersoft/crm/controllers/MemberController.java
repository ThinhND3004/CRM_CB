package com.cybersoft.crm.controllers;

import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.services.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private UserServiceImp userServiceImp;
    @GetMapping("")
    public String memberProcess(Model model)
    {
        List<UserEntity> userEntities = userServiceImp.getAllUser();

        model.addAttribute("users", userEntities);

        return "member";
    }

}
