CREATE TABLE ventas(
    id_venta BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    fecha DATETIME NOT NULL,
    serie VARCHAR(100) NOT NULL,
    numero VARCHAR(100) NOT NULL,
    total DECIMAL(15, 2) NOT NULL,

    CONSTRAINT fk_ventas_cliente_id FOREIGN KEY(cliente_id) references clientes(id_cliente)
);