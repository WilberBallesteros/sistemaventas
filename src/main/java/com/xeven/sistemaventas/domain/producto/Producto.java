package com.xeven.sistemaventas.domain.producto;

//persistencia de datos con nuestro modelo de base de datos

import com.xeven.sistemaventas.domain.cliente.DatosRegistroCliente;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "productos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idProducto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    private String descripcion;
    private Integer cantidad;
    private Boolean estado = true;

    public Producto(DatosRegistroProducto datosRegistroProducto) {
        this.descripcion = datosRegistroProducto.descripcion();
        this.cantidad = datosRegistroProducto.cantidad();
    }

    public void actualizarDatos(DatosActualizarProducto datosActualizarProducto) {

        if (datosActualizarProducto.descripcion() != null) {
            this.descripcion = datosActualizarProducto.descripcion();
        }
        if (datosActualizarProducto.cantidad() != null) {
            this.cantidad = datosActualizarProducto.cantidad();
        }
        if (datosActualizarProducto.estado() != null) {
            this.estado = datosActualizarProducto.estado();
        }
    }
}
