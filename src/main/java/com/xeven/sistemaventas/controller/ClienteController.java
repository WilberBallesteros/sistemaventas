package com.xeven.sistemaventas.controller;

import com.xeven.sistemaventas.domain.cliente.*;
import com.xeven.sistemaventas.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void registrarCliente(@RequestBody DatosRegistroCliente datosRegistroCliente) {
        clienteRepository.save(new Cliente(datosRegistroCliente));
    }

    @GetMapping
    public Page<DatosListadoCliente> listadoCliente(Pageable paginacion) {
        return clienteRepository.findAll(paginacion).map(DatosListadoCliente::new);
    }

    @PutMapping
    @Transactional
    public void actualizarCliente(@RequestBody @Valid DatosActualizarCliente datosActualizarCliente) {
        Cliente cliente = clienteRepository.getReferenceById(datosActualizarCliente.idCliente());
        cliente.actualizarCliente(datosActualizarCliente);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        clienteRepository.delete(cliente);
    }
}
