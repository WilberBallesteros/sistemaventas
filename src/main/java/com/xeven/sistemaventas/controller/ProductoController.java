package com.xeven.sistemaventas.controller;

import com.xeven.sistemaventas.domain.producto.*;
import com.xeven.sistemaventas.repository.ProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    //inyectar dependencias
    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping
    public void registrarProducto(@RequestBody DatosRegistroProducto datosRegistroProducto) {
        productoRepository.save(new Producto(datosRegistroProducto));
    }

    @GetMapping
    public Page<DatosListadoProducto> listadoProducto(Pageable paginacion) {
        Page<Producto> productosPaginados = productoRepository.findAllActive(paginacion);
        return productosPaginados.map(DatosListadoProducto::new);
    }

    @PutMapping
    @Transactional
    public void actualizarProducto(@RequestBody @Valid DatosActualizarProducto datosActualizarProducto) {
        Producto producto = productoRepository.getReferenceById(datosActualizarProducto.idProducto());
        producto.actualizarDatos(datosActualizarProducto );
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarProducto(@PathVariable Integer id) {
        Producto producto = productoRepository.getReferenceById(id);
        productoRepository.delete(producto);
    }
}
