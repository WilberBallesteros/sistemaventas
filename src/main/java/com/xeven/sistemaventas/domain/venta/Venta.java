package com.xeven.sistemaventas.domain.venta;

import com.xeven.sistemaventas.domain.cliente.Cliente;
import com.xeven.sistemaventas.domain.detalleVenta.DetalleVenta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Table(name = "ventas")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idVenta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "cliente_id")
    private Cliente cliente;
    private LocalDateTime fecha;
    private String serie;
    private String numero;
    private Double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalles = new ArrayList<>();


    public Venta(DatosRegistroVenta datosRegistroVenta) {
        this.fecha = LocalDateTime.now(); // Se establece la fecha actual
        this.serie = datosRegistroVenta.serie();
        this.numero = datosRegistroVenta.numero();
    }
}
