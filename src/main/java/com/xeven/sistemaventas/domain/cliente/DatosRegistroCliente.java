package com.xeven.sistemaventas.domain.cliente;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCliente(
        @NotBlank
        String nombres,
        @NotBlank
        String apellidos,
        @NotBlank
        String nroDocumento,
        @NotBlank
        String email
) {
}
