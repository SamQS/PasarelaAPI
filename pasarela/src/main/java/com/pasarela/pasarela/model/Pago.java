package com.pasarela.pasarela.model;
import javax.persistence;
import lombox.*;

@Getter
@Setter
@NoArgsContructor
@AllArgsContructor
@Builder
@Entity
@Table (name = "t_pago")

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Interger numeroTarjeta;
    private String tipoTarjeta;
    private Integer fechaVencimiento;
    private Integer codigoCcv;
    private String direccionTarjeta;
}