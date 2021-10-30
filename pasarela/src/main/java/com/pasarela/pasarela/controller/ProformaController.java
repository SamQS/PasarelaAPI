package com.pasarela.pasarela.controller;

import java.util.List;
import com.pasarela.pasarela.model.Pago;
import com.pasarela.pasarela.repository.PagoRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProformaController {
    

    private static final String INDEX ="Proforma/ProformaTarjeta"; 
    private final PagoRepository pagoData;

    public ProformaController(PagoRepository pagoData
    ){
    this.pagoData = pagoData;
    }
 
    

}
