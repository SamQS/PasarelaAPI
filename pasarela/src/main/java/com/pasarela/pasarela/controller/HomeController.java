package com.pasarela.pasarela.controller;

import com.pasarela.pasarela.model.Pago;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private static final String VIEW_DASHBOARD ="dashboard"; 
    private static final String VIEW_DASHBOARD2 ="dashboard2"; 
    private static final String VIEW_OPTION ="Dash/opcionDash"; 

    @GetMapping("/")
    public String index() {
        return "Inicio";
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return VIEW_DASHBOARD;
    }
    @GetMapping("/dashboard2")
    public String dashboard2(Model model) {
        return VIEW_DASHBOARD2;
    }
    @GetMapping("/Dash/opcionDash")
    public String opcionDash(Model model) {
        return VIEW_OPTION;
    }
}
