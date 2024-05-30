package com.cybersoft.crm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blank")
public class BlankPageController {

    @GetMapping
    public String blankPage()
    {
        return "blank";
    }

}
