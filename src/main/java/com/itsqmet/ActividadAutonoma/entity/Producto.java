package com.itsqmet.ActividadAutonoma.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "productos_inventario")
@Data
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<Factura> facturas;

    @NotBlank(message = "Nombre del producto es requerido")
    private String nombre;

    @Min(value = 0, message = "El precio debe ser mayor a 0")
    private Double precioUnitario;

    private String rutaImagen;
}