package com.pasarela.pasarela.controller;

import com.pasarela.pasarela.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.pasarela.pasarela.repository.*;
import java.util.*;



@RestController
@RequestMapping(value ="api/pasarela", produces ="application/json")
public class PasarelaController {

private Map<String,Pago> pagos;

    private final PagoRepository pagoData;
    

public PasarelaController(PagoRepository pagoData){

  
  this.pagoData = pagoData;
  pagos = new HashMap<String,Pago>();



}
@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity  <Map<String, Pago>> TarjetasRegistradas(){

    return new ResponseEntity<Map<String, Pago>>(pagos,HttpStatus.OK);

}
@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity <String> create(@RequestBody Pago pa){

  pagoData.save(pa);
  pagoData.flush();

    String id = UUID.randomUUID().toString();
    pa.setId(id);
    pagos.put(id, pa);
    
    return new ResponseEntity<String>(id,HttpStatus.CREATED);

}
@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Pago> TarjetasRegistradass(@PathVariable String id){
    if(pagos.containsKey(id)){
        Pago pa = pagos.get(id);
        return new ResponseEntity<Pago>(pa, HttpStatus.OK);
    }else{
        return new ResponseEntity<Pago>(HttpStatus.NOT_FOUND);
    }
} 

}