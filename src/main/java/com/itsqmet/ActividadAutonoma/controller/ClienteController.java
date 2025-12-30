package com.itsqmet.ActividadAutonoma.controller;


import com.itsqmet.ActividadAutonoma.entity.Cliente;
import com.itsqmet.ActividadAutonoma.service.ClienteService;
import com.itsqmet.ActividadAutonoma.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final ProductoService productoService;

    @GetMapping("/lista")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("productos", productoService.listarProductos());
        return "cliente/lista";
    }

    @GetMapping("/formulario")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/registro";
    }

    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/actualizar/{cedula}")
    public String actualizarCliente(@PathVariable String cedula, Model model) {
        clienteService.obtenerPorCedula(cedula).ifPresent(c -> model.addAttribute("cliente", c));
        return "cliente/registro";
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminarCliente(@PathVariable String cedula) {
        clienteService.eliminarCliente(cedula);
        return "redirect:/cliente/lista";
    }
}