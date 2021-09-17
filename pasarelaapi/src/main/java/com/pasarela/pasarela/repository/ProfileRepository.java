package com.pasarela.pasarela.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.pasarela.pasarela.model.*;
import java.util.Optional;
@Repository
public interface ProfileRepository  extends JpaRepository<Profile, Integer>{
    @Query(value = "SELECT o FROM Profile o WHERE o.dni=?1")
    Optional<Profile> findByDni(Integer dni);
    
    
}
