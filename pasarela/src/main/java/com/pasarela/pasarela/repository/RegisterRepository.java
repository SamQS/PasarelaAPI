package com.pasarela.pasarela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pasarela.pasarela.model.Register;
import com.pasarela.pasarela.model.Usuario;


@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer>{
    
    @Query(value = "SELECT o FROM Register o WHERE o.user=?1")
    Register findByUsuario(Usuario user);
}
