package com.xeven.sistemaventas.domain.cliente;

public record DatosListadoCliente(

        String nombres,
        String apellidos,
        String nroDocumento,
        String email

) {
    public DatosListadoCliente(Cliente cliente) {
        this(cliente.getNombres(), cliente.getApellidos(), cliente.getNroDocumento(),
                cliente.getEmail());
    }
}
