package com.xeven.sistemaventas.domain.cliente;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCliente(
        @NotNull
        Long idCliente,
        String nombres,
        String apellidos,
        String nroDocumento,
        String email
) {
}
