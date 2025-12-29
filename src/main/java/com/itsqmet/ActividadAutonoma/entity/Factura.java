package com.itsqmet.ActividadAutonoma.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facturas_emision")
@Data
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_codigo")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula")
    private Cliente cliente;

    @Min(value = 1, message = "La cantidad mínima es 1")
    private Integer cantidad;

    private Double subtotal;
    private Double total;
}