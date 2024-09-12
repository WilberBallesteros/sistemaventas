package com.xeven.sistemaventas.domain.cliente;

import com.xeven.sistemaventas.domain.producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
