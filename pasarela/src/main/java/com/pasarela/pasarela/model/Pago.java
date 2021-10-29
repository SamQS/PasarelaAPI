package com.pasarela.pasarela.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String nombreTarjeta;
    public Integer numeroTarjeta;
    private Integer fechaVencimiento;
    private String tipoTarjeta;
    private Integer codigoCcv;
    private Integer dni;
    private Integer monto;
    private Integer cantidad;
    
    

}
