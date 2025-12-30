package com.itsqmet.ActividadAutonoma.service;


import com.itsqmet.ActividadAutonoma.entity.Proveedor;
import com.itsqmet.ActividadAutonoma.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> obtenerPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    public void guardarProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}