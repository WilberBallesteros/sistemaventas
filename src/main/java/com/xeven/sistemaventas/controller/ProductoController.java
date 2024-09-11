package com.xeven.sistemaventas.controller;

import com.xeven.sistemaventas.domain.producto.DatosListadoProducto;
import com.xeven.sistemaventas.domain.producto.DatosRegistroProducto;
import com.xeven.sistemaventas.domain.producto.Producto;
import com.xeven.sistemaventas.domain.producto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
