package com.pasarela.pasarela.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;

import com.pasarela.pasarela.repository.*;

@RestController
@RequestMapping(value = "api/dashboard2", produces = "application/json")
public class Dashboard2Controller {
    
    private final BancariaRepository bancariaData;

    public Dashboard2Controller(BancariaRepository bancariaData){
        this.bancariaData = bancariaData;
    } 

    @GetMapping(value = "/cuentastotales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> cuentas(){
        return new ResponseEntity<List<Map<String, Object>>>(
            bancariaData.querySumaTotalBancaria(), HttpStatus.OK);
    }
}
