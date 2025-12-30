package com.itsqmet.ActividadAutonoma.repository;


import com.itsqmet.ActividadAutonoma.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}