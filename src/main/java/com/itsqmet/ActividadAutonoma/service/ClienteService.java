package com.itsqmet.ActividadAutonoma.service;


import com.itsqmet.tienda_app.entity.Cliente;
import com.itsqmet.tienda_app.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerPorCedula(String cedula) {
        return clienteRepository.findById(cedula);
    }

    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(String cedula) {
        clienteRepository.deleteById(cedula);
    }
}