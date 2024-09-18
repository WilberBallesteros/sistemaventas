package com.xeven.sistemaventas.repository;

import com.xeven.sistemaventas.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
