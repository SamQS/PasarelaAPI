package com.pasarela.pasarela.controller;

import com.pasarela.pasarela.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.pasarela.pasarela.repository.*;
import java.util.*;



@RestController
@RequestMapping(value ="api/pasarela", produces ="application/json")
public class PasarelaController {


    private final PagoRepository pagoData;
    

public PasarelaController(PagoRepository pagoData){

  
  this.pagoData = pagoData;


}
//Tarjeta
@PostMapping(value = "/{createTarjeta}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity <Integer> createTarjeta(@RequestBody Pago pa){

  pagoData.save(pa);
  pagoData.flush();
    
    return new ResponseEntity<Integer>(pa.getNumeroTarjeta(), HttpStatus.CREATED);

}
@GetMapping(value = "/{numeroTarjeta}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Pago> NumTarjeta(@PathVariable Integer numeroTarjeta){
    Optional<Pago> optPago = pagoData.findByNumTarjeta(numeroTarjeta);
    if(optPago.isPresent()){
        Pago pa = optPago.get();
        return new ResponseEntity<Pago>(pa, HttpStatus.OK);
    }else{
        return new ResponseEntity<Pago>(HttpStatus.NOT_FOUND);
    }
} 
}