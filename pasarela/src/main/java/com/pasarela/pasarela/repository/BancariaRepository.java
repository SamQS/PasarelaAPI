package com.pasarela.pasarela.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.pasarela.pasarela.model.*;

import java.util.*;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BancariaRepository extends JpaRepository<Bancaria, String> {
    
    @Query("SELECT nombreBanco as nombreBanco, SUM(b.monto) as monto FROM Bancaria b GROUP BY b.nombreBanco")
    List<Map<String, Object>> querySumaTotalBancaria();
}
