package com.itsqmet.ActividadAutonoma.service;


import com.itsqmet.ActividadAutonoma.entity.Factura;
import com.itsqmet.ActividadAutonoma.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    public Optional<Factura> obtenerPorId(Long id) {
        return facturaRepository.findById(id);
    }

    public void guardarFactura(Factura factura) {
        facturaRepository.save(factura);
    }

    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}