package com.cybersoft.crm.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping("")
    public String processLogin(HttpServletResponse response)
    {
        try {

            Cookie email = new Cookie("email", "");
            Cookie password = new Cookie("password", "");
            Cookie role = new Cookie("role", "");

            email.setMaxAge(0);
            password.setMaxAge(0);
            role.setMaxAge(0);

            response.addCookie(email);
            response.addCookie(password);
            response.addCookie(role);

        } catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }
        return "redirect:./login";
    }

}
