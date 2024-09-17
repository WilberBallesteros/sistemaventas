package com.xeven.sistemaventas.domain.venta;

import com.xeven.sistemaventas.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "cliente_id")
    private Cliente cliente;
    private LocalDateTime fecha;
    private String serie;
    private String numero;
    private Double total;
}
