package com.cybersoft.crm.controllers;

import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.services.Imp.LoginServiceImp;
import com.cybersoft.crm.services.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImp loginServiceImp;


    @GetMapping("")
    public String login(HttpServletRequest request, Model model)
    {
        Cookie[] cookies = request.getCookies();
        String email = "";
        String password = "";

        if(cookies != null && cookies.length > 0)
        {
            for(Cookie cookie : cookies)
            {
                if("email".equals(cookie.getName())) {
                    email = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    password = cookie.getValue();
                }
            }
        }
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        return "login";
    }

    @PostMapping("")
    public String LoginHandler(@RequestParam String email, @RequestParam String password, Model model, HttpServletResponse response)
    {
        if(loginServiceImp.checkLogin(email, password))
        {
            UserEntity user = loginServiceImp.getByEmail(email);

            RoleEntity role = user.getRoleEntity();

            Cookie userEmail = new Cookie("email", user.getEmail());
            Cookie userPassword = new Cookie("password", user.getPassword());
            Cookie userRole = new Cookie("role", user.getRoleEntity().getName());


            response.addCookie(userEmail);
            response.addCookie(userPassword);
            response.addCookie(userRole);



            return "redirect:/index";
        } else {

            System.out.println("That bai");
            UserEntity user = loginServiceImp.getByEmail(email);
            System.out.println("Kiem tra: " + user.getFullname());
            model.addAttribute("loginFail", true);
            return "login";
        }

    }

}
