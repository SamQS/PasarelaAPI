package com.pasarela.pasarela.repository;

import com.pasarela.pasarela.model.OpcionesPago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionesPagoRepository extends JpaRepository<OpcionesPago,String> {
    
}
