package com.itsqmet.ActividadAutonoma.controller;


import com.itsqmet.ActividadAutonoma.entity.Proveedor;
import com.itsqmet.ActividadAutonoma.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedor")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping("/lista")
    public String mostrarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        return "proveedor/lista";
    }

    @GetMapping("/formulario")
    public String mostrarFormularioProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/registro";
    }

    @PostMapping("/guardar")
    public String guardarProveedor(Proveedor proveedor) {
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedor/lista";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarProveedor(@PathVariable Long id, Model model) {
        proveedorService.obtenerPorId(id).ifPresent(p -> model.addAttribute("proveedor", p));
        return "proveedor/registro";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return "redirect:/proveedor/lista";
    }
}