package com.xeven.sistemaventas.domain.producto;

public record DatosListadoProducto(
        String descripcion,
        Integer cantidad
) {
    public DatosListadoProducto(Producto producto) {

        this(producto.getDescripcion(), producto.getCantidad());
    }
}
