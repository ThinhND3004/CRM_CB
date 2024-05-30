package com.cybersoft.crm.controllers;

import com.cybersoft.crm.dto.UserDTO;
import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.services.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private static final String REGISTER = "register";
    private static final String REGISTER_PAGE = "redirect:./register";
    private static final String LOGIN = "redirect:./login";
    private static final String ERROR_INPUT_MESSAGE = "Please enter validly.";


    @Autowired
    private UserServiceImp userServiceImp;



    @GetMapping("")
    public String register()
    {
        String url = REGISTER;

        return url;
    }

    @PostMapping("")
    public String registerProcess(Model model, @RequestParam String fullName, @RequestParam String email, @RequestParam String password)
    {
        String url = REGISTER;
        UserDTO userDTO = null;
        String message = ERROR_INPUT_MESSAGE;
        boolean saveSuccess = false;

        if(!fullName.isEmpty() && !email.isEmpty() && !password.isEmpty())
        {
            userDTO = new UserDTO(email,fullName,password);

            message = userServiceImp.checkRegister(userDTO);
        }

        model.addAttribute("REGISTER_ERROR_MESSAGE", message);

        saveSuccess = userServiceImp.saveNewUserToDB(userDTO);

        if(!message.equals(ERROR_INPUT_MESSAGE) && saveSuccess)
        {
            url = LOGIN;
        }

        return url;
    }




}
