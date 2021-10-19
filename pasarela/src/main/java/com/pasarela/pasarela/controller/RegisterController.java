package com.pasarela.pasarela.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import com.pasarela.pasarela.model.Register;
import com.pasarela.pasarela.repository.RegisterRepository;
import com.pasarela.pasarela.model.Usuario;
import com.pasarela.pasarela.repository.UsuarioRepository;

@Controller
public class RegisterController {
    
    private static final String INDEX ="cliente/create"; 
    private static String MODEL_CONTACT="client";
    private final RegisterRepository registerData;
    private final UsuarioRepository usuariosData;

    public RegisterController(RegisterRepository registerData,
        UsuarioRepository usuariosData    
        ){
        this.registerData = registerData;
        this.usuariosData = usuariosData;
    }      

    @GetMapping("/cliente/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Register());
        return INDEX;
    }    

    @PostMapping("/cliente/create")
    public String create(Model model, 
        @Valid Register objRegister, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro con exito");
        }else{
            Usuario user = objRegister.getUser();
            user.setTipoUsuario("C");
            this.usuariosData.save(user);
            this.usuariosData.flush();
            this.registerData.save(objRegister);
            model.addAttribute(MODEL_CONTACT, objRegister);
            model.addAttribute("mensaje", "Se registro con exito");
        }
        return INDEX;
    }

}