package com.pasarela.pasarela.repository;



import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pasarela.pasarela.model.*;

import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PagoRepository extends JpaRepository<Pago, String>{
    
    
    @Query("SELECT tipoTarjeta as tipoTarjeta, SUM(p.monto) as montoTotal FROM Pago p GROUP BY p.tipoTarjeta")
    List<Map<String, Object>> querySumaTotal();
    
}
