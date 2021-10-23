package com.pasarela.pasarela.controller;

import javax.validation.Valid;

import com.pasarela.pasarela.model.Bancaria;
import com.pasarela.pasarela.repository.BancariaRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class BancariaController {
     private static final String INDEX = "PagoBancaria/PagoBancaria";
     private static String MODEL_BANCAR="banco";
     private final BancariaRepository bancarData;
     public BancariaController(BancariaRepository bancarData){
        this.bancarData = bancarData;
    }    

     @GetMapping("/PagoBancaria/PagoBancaria")
     public String index(Model model) {
         model.addAttribute(MODEL_BANCAR, new Bancaria());
         return INDEX;
     }
     @PostMapping("/PagoBancaria/PagoBancaria")
    public String createSubmitForm(Model model, 
        @Valid Bancaria objBancar, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro su pago");
        }else{
            this.bancarData.save(objBancar);
            model.addAttribute(MODEL_BANCAR, objBancar);
            model.addAttribute("mensaje", "Se registro su pago");
        }
        return INDEX;
    }
     
}