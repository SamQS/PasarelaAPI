package com.pasarela.pasarela.repository;
import org.springframework.stereotype.*;

public interface PagoRepository extends JpaRepository<Pago, Integer>{
    @Query(value = "SELECT o FROM Pago o WHERE o.numeroTarjeta=?1")
    Optional<Pago> findByNumeroTarjeta(Integer numeroTarjeta);
}