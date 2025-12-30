package com.itsqmet.ActividadAutonoma.controller;


import com.itsqmet.ActividadAutonoma.entity.Producto;
import com.itsqmet.ActividadAutonoma.service.ProductoService;
import com.itsqmet.ActividadAutonoma.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final ProveedorService proveedorService;

    @GetMapping("/lista")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "producto/lista";
    }

    @GetMapping("/formulario")
    public String mostrarFormularioProducto(Model model) {
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        model.addAttribute("producto", new Producto());
        return "producto/registro";
    }

    @PostMapping("/guardar")
    public String guardarProducto(Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/producto/lista";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarProducto(@PathVariable Long id, Model model) {
        productoService.obtenerPorId(id).ifPresent(p -> model.addAttribute("producto", p));
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        return "producto/registro";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/producto/lista";
    }
}