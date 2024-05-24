package com.cybersoft.crm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/403")
public class ErrorController {

    @GetMapping()
    public String errorPage()
    {
        return "404";
    }

}
