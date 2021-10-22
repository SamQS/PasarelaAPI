package com.pasarela.pasarela.repository;

import com.pasarela.pasarela.model.Contacto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
     
}
