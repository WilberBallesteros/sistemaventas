package com.xeven.sistemaventas.repository;

import com.xeven.sistemaventas.domain.detalleVenta.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}
