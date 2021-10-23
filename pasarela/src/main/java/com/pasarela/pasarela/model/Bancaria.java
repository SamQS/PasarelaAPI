package com.pasarela.pasarela.model;
import javax.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Integer id;
    private String nombreBancaria;
    private Integer numeroCuenta;
    private String nombreBanco; 
    private Integer dni;         
    private Integer monto;
}
