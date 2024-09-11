package com.xeven.sistemaventas.domain.producto;

//persistencia de datos con nuestro modelo de base de datos

import jakarta.persistence.*;
import lombok.*;

@Table(name = "productos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    private String descripcion;
    private Integer cantidad;
    private Boolean estado = true;

    public Producto(DatosRegistroProducto datosRegistroProducto) {
        this.descripcion = datosRegistroProducto.descripcion();
        this.cantidad = datosRegistroProducto.cantidad();
    }
}
