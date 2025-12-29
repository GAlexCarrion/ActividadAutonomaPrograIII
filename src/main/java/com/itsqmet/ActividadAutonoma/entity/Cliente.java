package com.itsqmet.ActividadAutonoma.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes_tienda") // Diferenciador
@Data
@NoArgsConstructor
public class Cliente {
    @Id
    @NotBlank(message = "La cédula es obligatoria")
    @Size(min = 10, max = 13, message = "Cédula debe tener entre 10 y 13 dígitos")
    private String cedula;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    private String direccion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La fecha debe ser anterior a hoy")
    private Date fechaNacimiento;
}