package com.pasarela.pasarela.controller;

import com.pasarela.pasarela.model.Pago;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;



@Controller
public class HomeController {

    private static final String VIEW_DASHBOARD ="dashboard"; 
    private static final String VIEW_CONTACT ="pago"; 
    @GetMapping("/")
    public String index() {
        return "Inicio";
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return VIEW_DASHBOARD;
    }

    @GetMapping("/Proforma/ProformaTarjeta")
    public String proformat(Model model) {
         model.addAttribute(VIEW_CONTACT, new Pago());
         return VIEW_CONTACT;
     }
}
