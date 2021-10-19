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
private Map<String,Bancaria> bancarias;

    private final PagoRepository pagoData;
    private final BancariaRepository bancariaData;
    

public PasarelaController(PagoRepository pagoData,BancariaRepository bancariaData){

  
  this.pagoData = pagoData;
  this.bancariaData = bancariaData;
  pagos = new HashMap<String,Pago>();
  bancarias = new HashMap<String,Bancaria>();



}
@GetMapping(value = "/{TarjetasRegistradas}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity  <Map<String, Pago>> TarjetasRegistradas(){

    return new ResponseEntity<Map<String, Pago>>(pagos,HttpStatus.OK);

}
@PostMapping(value = "/{createTarjeta}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity <String> createTarjeta(@RequestBody Pago pa){

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



//BAncaria
@GetMapping(value = "/{CuentasBancarias}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity  <Map<String, Bancaria>> CuentasBancarias(){

    return new ResponseEntity <Map<String, Bancaria>> (bancarias,HttpStatus.OK);

}

@PostMapping(value = "/{CuentasBancarias}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity <String> createCuentaBancaria(@RequestBody Bancaria ba){

    bancariaData.save(ba);
    bancariaData.flush();

    String id = UUID.randomUUID().toString();
    ba.setId(id);
    bancarias.put(id, ba);
    
    return new ResponseEntity<String>(id,HttpStatus.CREATED);

}


@GetMapping(value = "/{id}CuentasBancarias", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Bancaria> CuentasBancarias(@PathVariable String id){
    if(bancarias.containsKey(id)){
        Bancaria ba = bancarias.get(id);
        return new ResponseEntity<Bancaria>(ba, HttpStatus.OK);
    }else{
        return new ResponseEntity<Bancaria>(HttpStatus.NOT_FOUND);
    }
} 


}