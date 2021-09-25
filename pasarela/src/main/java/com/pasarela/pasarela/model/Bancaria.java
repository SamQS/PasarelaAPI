package com.pasarela.pasarela.model;
import javax.persistence.*;
import lombok.*;
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_banco")
public class Bancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroCuenta;
    private Integer dni;

    private Integer nombreBanco;
    
    
    private Integer telefono;
}
