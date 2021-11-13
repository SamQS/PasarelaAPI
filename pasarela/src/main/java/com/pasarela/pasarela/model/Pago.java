package com.pasarela.pasarela.model;

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
    @Column(name="pago_id")
    private Integer id;
    private String nombreTarjeta;
    private Integer numeroTarjeta;
    private Integer fechaVencimiento;
    private String tipoTarjeta;
    private Integer codigoCcv;
    private Integer dni;
    private Integer monto;
    
    
    

}
