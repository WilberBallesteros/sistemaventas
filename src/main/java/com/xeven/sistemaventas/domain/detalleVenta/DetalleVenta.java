package com.xeven.sistemaventas.domain.detalleVenta;

import com.xeven.sistemaventas.domain.producto.Producto;
import com.xeven.sistemaventas.domain.venta.Venta;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "detalle_ventas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idDetalle")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "venta_id")
    private Venta venta;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "producto_id")
    private Producto producto;
    private Integer cantidad;
    private Double precio;
    @Column(name = "sub_total")
    private Double subTotal;
}
