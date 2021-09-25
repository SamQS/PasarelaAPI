package com.pasarela.pasarela.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.pasarela.pasarela.model.*;

import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BancariaRepository extends JpaRepository<Bancaria, Integer> {
    @Query(value = "SELECT o FROM Bancaria o WHERE o.numeroCuenta=?1")
    Optional<Bancaria> findByNumeroCuenta(Integer numeroCuenta);
}
