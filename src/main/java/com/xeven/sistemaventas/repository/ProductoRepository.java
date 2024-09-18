package com.xeven.sistemaventas.repository;

import com.xeven.sistemaventas.domain.producto.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//todo el proceso de gestion con la bd a nivel del crud
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE p.estado = true")
    Page<Producto> findAllActive(Pageable pageable);

}
