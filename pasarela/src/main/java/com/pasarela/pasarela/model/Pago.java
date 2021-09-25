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
    private Integer id;
    
    private Integer numeroTarjeta;

    private String tipoTarjeta;

    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private Integer fechaVencimiento;
    
    private Integer codigoCcv;

    private String direccionTarjeta;

    private BigDecimal montoTotal;


}
