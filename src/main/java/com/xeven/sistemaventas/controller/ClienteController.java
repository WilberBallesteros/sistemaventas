package com.xeven.sistemaventas.controller;

import com.xeven.sistemaventas.domain.cliente.Cliente;
import com.xeven.sistemaventas.domain.cliente.ClienteRepository;
import com.xeven.sistemaventas.domain.cliente.DatosRegistroCliente;
import com.xeven.sistemaventas.domain.producto.DatosRegistroProducto;
import com.xeven.sistemaventas.domain.producto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void registrarCliente(@RequestBody DatosRegistroCliente datosRegistroCliente) {
        clienteRepository.save(new Cliente(datosRegistroCliente));
    }
}
