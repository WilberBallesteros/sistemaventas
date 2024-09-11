CREATE TABLE productos(
    id_producto INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(200) NOT NULL UNIQUE,
    cantidad INT NOT NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,

    PRIMARY KEY(id_producto)
);