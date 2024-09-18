package com.xeven.sistemaventas.domain.venta;

import com.xeven.sistemaventas.domain.detalleVenta.DatosRegistroDetalle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRegistroVenta(
        @NotNull
        Long clienteId,
        @NotBlank
        String serie,
        @NotBlank
        String numero,
        @NotNull
        List<DatosRegistroDetalle> detalles
) {
}
