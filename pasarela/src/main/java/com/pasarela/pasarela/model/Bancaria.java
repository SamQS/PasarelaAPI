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
    private String id;
    private Integer numeroCuenta;
    private Integer dni;
    private String nombreBanco;      
    private Integer telefono;
}
