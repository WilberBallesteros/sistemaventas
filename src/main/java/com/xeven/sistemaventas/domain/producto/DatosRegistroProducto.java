package com.xeven.sistemaventas.domain.producto;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroProducto(
        @NotBlank
        String descripcion,
        @NotBlank
        Integer cantidad
) {
}
