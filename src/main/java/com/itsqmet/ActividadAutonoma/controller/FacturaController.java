package com.itsqmet.ActividadAutonoma.controller;


import com.itsqmet.ActividadAutonoma.entity.Factura;
import com.itsqmet.ActividadAutonoma.service.ClienteService;
import com.itsqmet.ActividadAutonoma.service.FacturaService;
import com.itsqmet.ActividadAutonoma.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/factura")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;
    private final ClienteService clienteService;
    private final ProductoService productoService;

    @GetMapping("/lista")
    public String mostrarFacturas(Model model) {
        model.addAttribute("facturas", facturaService.listarFacturas());
        return "factura/lista";
    }

    @GetMapping("/formulario")
    public String mostrarFormularioFactura(@RequestParam String cedula, @RequestParam Long productoId, Model model) {
        Factura factura = new Factura();
        clienteService.obtenerPorCedula(cedula).ifPresent(factura::setCliente);
        productoService.obtenerPorId(productoId).ifPresent(factura::setProducto);

        model.addAttribute("factura", factura);
        return "factura/registro";
    }

    @PostMapping("/guardar")
    public String guardarFactura(Factura factura) {
        facturaService.guardarFactura(factura);
        return "redirect:/factura/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return "redirect:/factura/lista";
    }
}