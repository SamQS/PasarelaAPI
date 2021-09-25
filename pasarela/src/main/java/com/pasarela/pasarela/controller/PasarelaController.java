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
    private final BancariaRepository bancariaData;

public PasarelaController(PagoRepository pagoData, BancariaRepository bancariaData){

  
  this.pagoData = pagoData;
  pagos = new HashMap<String,Pago>();

  this.bancariaData = bancariaData;

}
@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity <List<Pago>> TarjetasRegistradas(){

    return new ResponseEntity<List<Pago>>(HttpStatus.OK);

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
public ResponseEntity<Pago> find(@PathVariable String id){
    if(pagos.containsKey(id)){
        Pago p = pagos.get(id);
        return new ResponseEntity<Pago>(p, HttpStatus.OK);
    }else{
        return new ResponseEntity<Pago>(HttpStatus.NOT_FOUND);
    }
} 

}