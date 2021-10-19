package com.pasarela.pasarela.repository;

import org.springframework.stereotype.Repository;
import com.pasarela.pasarela.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,String> {
    
}
