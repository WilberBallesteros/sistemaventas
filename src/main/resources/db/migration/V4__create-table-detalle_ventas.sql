CREATE TABLE detalle_ventas(
    id_detalle BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    venta_id BIGINT NOT NULL,
    producto_id INT NOT NULL,
    fecha DATETIME NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(15, 2) NOT NULL,
    sub_total DECIMAL(15, 2) NOT NULL,

    CONSTRAINT fk_detalle_venta_id FOREIGN KEY(venta_id) references ventas(id_venta),
    CONSTRAINT fk_detalle_producto_id FOREIGN KEY(producto_id) references productos(id_producto)
);