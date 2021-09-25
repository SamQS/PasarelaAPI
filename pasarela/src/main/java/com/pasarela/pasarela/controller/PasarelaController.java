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
    private final BancariaRepository bancariaData;

public PasarelaController(PagoRepository pagoData, BancariaRepository bancariaData){

  
  this.pagoData = pagoData;
  this.bancariaData = bancariaData;

}

@PostMapping(value = "/crearTarjeta", produces = MediaType.APPLICATION_JSON_VALUE)    
public ResponseEntity<Integer> registrarTarjeta(@RequestBody Pago pa){
  pagoData.save(pa);
  pagoData.flush();    
  return  new ResponseEntity<Integer>(pa.getId(), HttpStatus.CREATED);    
}

@GetMapping(value = "/tarjetas", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Pago> Tarjetas(@PathVariable Integer numeroTarjeta){
  Optional<Pago> optTarj = pagoData.findByNumeroTarjeta(numeroTarjeta);
  if(optTarj.isPresent()){
      return new ResponseEntity<Pago>(optTarj.get(),HttpStatus.OK);
  }else{
      return new ResponseEntity<Pago>(HttpStatus.NOT_FOUND);
  }  
}
@GetMapping(value = "/tarjetas--", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pago>> Tarjetass() {
        return new ResponseEntity<List<Pago>>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/BorrarTarjeta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pago> deleteTarjeta(@PathVariable Integer numeroTarjeta) {
      pagoData.findByNumeroTarjeta(numeroTarjeta);
        return new ResponseEntity<Pago>(HttpStatus.OK);
    }

    @PostMapping(value = "/registrarCuenta", produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Integer> registrarCuentaBancaria(@RequestBody Bancaria ba){
      bancariaData.save(ba);
      bancariaData.flush();    
      return  new ResponseEntity<Integer>(ba.getId(), HttpStatus.CREATED);    
    }
    @GetMapping(value = "/Cuentas", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Bancaria> cuentas(@PathVariable Integer numeroCuenta){
  Optional<Bancaria> optBanc = bancariaData.findByNumeroCuenta(numeroCuenta);
  if(optBanc.isPresent()){
      return new ResponseEntity<Bancaria>(optBanc.get(),HttpStatus.OK);
  }else{
      return new ResponseEntity<Bancaria>(HttpStatus.NOT_FOUND);
  }  
}





}