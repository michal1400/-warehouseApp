package com.company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public String loadingPage (){
        return "redirect:/main-menu";
    }

    @RequestMapping(value = "/main-menu", method = RequestMethod.GET)
    public String mainMenu() {
        return "main-menu";
    }

}
