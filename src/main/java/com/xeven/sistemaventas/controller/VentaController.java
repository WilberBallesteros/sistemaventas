package com.xeven.sistemaventas.controller;

import com.xeven.sistemaventas.domain.venta.DatosRegistroVenta;
import com.xeven.sistemaventas.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public void registrarVenta(@RequestBody @Valid DatosRegistroVenta datosRegistroVenta) {
        ventaService.registrarVenta(datosRegistroVenta);
    }
}
