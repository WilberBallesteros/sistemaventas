package com.xeven.sistemaventas.service;

import com.xeven.sistemaventas.domain.cliente.Cliente;
import com.xeven.sistemaventas.domain.detalleVenta.DatosRegistroDetalle;
import com.xeven.sistemaventas.domain.detalleVenta.DetalleVenta;
import com.xeven.sistemaventas.domain.producto.Producto;
import com.xeven.sistemaventas.domain.venta.DatosRegistroVenta;
import com.xeven.sistemaventas.domain.venta.Venta;
import com.xeven.sistemaventas.repository.ClienteRepository;
import com.xeven.sistemaventas.repository.DetalleVentaRepository;
import com.xeven.sistemaventas.repository.ProductoRepository;
import com.xeven.sistemaventas.repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void registrarVenta(DatosRegistroVenta datosRegistroVenta) {
        Cliente cliente = clienteRepository.findById(datosRegistroVenta.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + datosRegistroVenta.clienteId()));

        Venta venta = new Venta(datosRegistroVenta);
        venta.setFecha(LocalDateTime.now()); // Establecer la fecha actual
        venta.setCliente(cliente); // Establecer el cliente aquí

        double total = 0.0;
        for (DatosRegistroDetalle detalle : datosRegistroVenta.detalles()) {
            Producto producto = productoRepository.findById(detalle.productoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detalle.productoId()));

            if (producto.getCantidad() < detalle.cantidad()) {
                throw new RuntimeException("No hay suficiente stock para el producto: " + producto.getIdProducto());
            }

            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProducto(producto);
            detalleVenta.setCantidad(detalle.cantidad());
            detalleVenta.setPrecio(detalle.precio());

            double subTotal = detalle.calcularSubTotal();  // Usa el método del DTO
            detalleVenta.setSubTotal(subTotal);

            detalleVenta.setVenta(venta);
            venta.getDetalles().add(detalleVenta);

            total += subTotal;  // Acumula el total

            producto.setCantidad(producto.getCantidad() - detalle.cantidad());
            productoRepository.save(producto);
        }

        venta.setTotal(total); // Establecer el total calculado
        ventaRepository.save(venta);
    }
}
