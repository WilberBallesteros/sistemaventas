CREATE TABLE clientes (
    id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(200) NOT NULL,
    apellidos VARCHAR(200) NOT NULL,
    nro_documento VARCHAR(255) UNIQUE,
    email VARCHAR(100) NOT NULL,
    create_at DATETIME NOT NULL
);