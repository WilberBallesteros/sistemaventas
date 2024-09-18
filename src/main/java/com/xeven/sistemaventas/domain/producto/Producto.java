package com.xeven.sistemaventas.domain.producto;

//persistencia de datos con nuestro modelo de base de datos

import com.xeven.sistemaventas.domain.cliente.DatosRegistroCliente;
import com.xeven.sistemaventas.domain.detalleVenta.DetalleVenta;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalles = new ArrayList<>();

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
