package com.xeven.sistemaventas.domain.detalleVenta;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroDetalle(
        @NotNull
        Integer productoId,
        @NotNull
        Integer cantidad,
        @NotNull
        Double precio

) {
    public Double calcularSubTotal() {
        return precio * cantidad;
    }
}
