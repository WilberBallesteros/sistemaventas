package com.xeven.sistemaventas.domain.producto;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarProducto(
        @NotNull
        Integer idProducto,
        String descripcion,
        Integer cantidad,
        Boolean estado
) {
}
