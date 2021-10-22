package com.pasarela.pasarela.controller;

import javax.validation.Valid;

import com.pasarela.pasarela.model.Pago;
import com.pasarela.pasarela.repository.PagoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class TarjetaController {
     private static final String INDEX = "PagoTarjeta/PagoTarjeta";
     private static String MODEL_TARJE="tarje";
     private final PagoRepository tarjeData;
     public TarjetaController(PagoRepository tarjeData){
        this.tarjeData = tarjeData;
    }    

     @GetMapping("/PagoTarjeta/PagoTarjeta")
     public String index(Model model) {
         model.addAttribute(MODEL_TARJE, new Pago());
         return INDEX;
     }
     @PostMapping("/PagoTarjeta/PagoTarjeta")
    public String createSubmitForm(Model model, 
        @Valid Pago objTarje, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro su pago");
        }else{
            this.tarjeData.save(objTarje);
            model.addAttribute(MODEL_TARJE, objTarje);
            model.addAttribute("mensaje", "Se registro su pago");
        }
        return INDEX;
    }
     
}