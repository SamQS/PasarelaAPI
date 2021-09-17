package com.pasarela.pasarela.controller;

import com.pasarela.pasarela.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.pasarela.pasarela.repository.*;
import java.util.*;



@RestController
@RequestMapping(value ="api/pasarela", produces ="application/json")
public class PasarelaController {

    private final ProfileRepository profileData;
    private final PagoRepository pagoData;

public PasarelaController(ProfileRepository profileData,  PagoRepository pagoData){

  
  this.profileData = profileData;
  this.pagoData = pagoData;

}

@PostMapping(value = "/{crearTarjeta}", produces = MediaType.APPLICATION_JSON_VALUE)    
public ResponseEntity<Integer> registrarTarjeta(@RequestBody Pago pa){
  pagoData.save(pa);
  pagoData.flush();    
  return  new ResponseEntity<Integer>(pa.getId(), HttpStatus.CREATED);

    
}
@PostMapping(value = "/{crearProfile}", produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Integer> crearProfile(@RequestBody Profile p){
      profileData.save(p);
      profileData.flush();
      return  new ResponseEntity<Integer>(p.getDni(), HttpStatus.CREATED);

        
}
@GetMapping(value = "/{tarjetas}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Pago> Tarjetas(@PathVariable Integer numeroTarjeta){
  Optional<Pago> optTarj = pagoData.findByNumeroTarjeta(numeroTarjeta);
  if(optTarj.isPresent()){
      return new ResponseEntity<Pago>(optTarj.get(),HttpStatus.OK);
  }else{
      return new ResponseEntity<Pago>(HttpStatus.NOT_FOUND);
  }  
}
@GetMapping(value = "/{tarjetas--}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pago>> Tarjetass() {
        return new ResponseEntity<List<Pago>>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{BorrarTarjeta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pago> deleteTarjeta(@PathVariable Integer numeroTarjeta) {
      pagoData.findByNumeroTarjeta(numeroTarjeta);
        return new ResponseEntity<Pago>(HttpStatus.OK);
    }

    @GetMapping(value = "/{Perfiles}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Profile> Profiles(@PathVariable Integer dni){
  Optional<Profile> optPro = profileData.findByDni(dni);
  if(optPro.isPresent()){
      return new ResponseEntity<Profile>(optPro.get(),HttpStatus.OK);
  }else{
      return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
  }  
}
}