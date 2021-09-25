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
    private String id;
    private Integer numeroTarjeta;
    private String tipoTarjeta;
    private Integer fechaVencimiento;
    private Integer codigoCcv;
    private String direccionTarjeta;
    

}
