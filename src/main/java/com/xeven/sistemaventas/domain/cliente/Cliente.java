package com.xeven.sistemaventas.domain.cliente;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "clientes")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idCliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private String nombres;
    private String apellidos;
    @Column(name = "nro_documento")
    private String nroDocumento;
    private String email;
    @Column(name = "create_at")
    private LocalDateTime createAt;

    public Cliente(DatosRegistroCliente datosRegistroCliente) {
        this.nombres = datosRegistroCliente.nombres();
        this.apellidos = datosRegistroCliente.apellidos();
        this.nroDocumento = datosRegistroCliente.nroDocumento();
        this.email = datosRegistroCliente.email();
        this.createAt = LocalDateTime.now();
    }
}
