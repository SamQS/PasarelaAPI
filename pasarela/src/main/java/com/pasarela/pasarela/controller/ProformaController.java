package com.pasarela.pasarela.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.pasarela.pasarela.model.*;
import com.pasarela.pasarela.repository.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.pasarela.pasarela.model.Usuario;

@Controller
public class ProformaController {
    

    private static final String INDEX ="Proforma/ProformaTarjeta"; 
    private final ProformaRepository proformaData;

    public ProformaController(ProformaRepository proformaData
    ){
    this.proformaData = proformaData;
    }



    @GetMapping("/Proforma/ProformaTarjeta")
    public String index(Model model, HttpSession session){
        Usuario user = (Usuario)session.getAttribute("user"); 
        List<Proforma> listItems = this.proformaData.findItemsByUsuario(user);
        model.addAttribute("proformas",listItems);
        return INDEX;
    }    

 
    

}
