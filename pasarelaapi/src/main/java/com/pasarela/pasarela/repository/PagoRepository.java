package com.pasarela.pasarela.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.pasarela.pasarela.model.*;

import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{
    @Query(value = "SELECT o FROM Pago o WHERE o.numeroTarjeta=?1")
    Optional<Pago> findByNumeroTarjeta(Integer numeroTarjeta);
    
}
