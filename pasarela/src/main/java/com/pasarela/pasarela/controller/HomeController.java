package com.pasarela.pasarela.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;



@Controller
public class HomeController {

    private static final String VIEW_DASHBOARD ="dashboard"; 
    
    @GetMapping("/")
    public String index() {
        return "Inicio";
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return VIEW_DASHBOARD;
    }
}
