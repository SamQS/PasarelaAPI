package com.pasarela.pasarela.controller;

import javax.validation.Valid;

import com.pasarela.pasarela.model.Contacto;
import com.pasarela.pasarela.repository.ContactoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ContactoController {
     private static final String INDEX = "Contacto/Contacto";
     private static String MODEL_CONTACT="contact";
     private final ContactoRepository contactsData;
     public ContactoController(ContactoRepository contactsData){
        this.contactsData = contactsData;
    }    

     @GetMapping("/Contacto/Contacto")
     public String index(Model model) {
         model.addAttribute(MODEL_CONTACT, new Contacto());
         return INDEX;
     }
     @PostMapping("/Contacto/Contacto")
    public String createSubmitForm(Model model, 
        @Valid Contacto objContact, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un contacto");
        }else{
            this.contactsData.save(objContact);
            model.addAttribute(MODEL_CONTACT, objContact);
            model.addAttribute("mensaje", "Se registro un contacto");
        }
        return INDEX;
    }
     
}
