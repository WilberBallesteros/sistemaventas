package com.xeven.sistemaventas.repository;

import com.xeven.sistemaventas.domain.venta.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
