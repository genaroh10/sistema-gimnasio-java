CREATE DATABASE IF NOT EXISTS gimnasio;

USE gimnasio;

CREATE TABLE IF NOT EXISTS socios (
    id_socio INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    dni VARCHAR(20),
    telefono VARCHAR(20),
    email VARCHAR(100),
    fecha_alta DATE
);

CREATE TABLE IF NOT EXISTS pagos (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT,
    fecha_pago DATE,
    monto DECIMAL(10,2),
    metodo_pago VARCHAR(30),
    FOREIGN KEY (id_socio) REFERENCES socios(id_socio)
);

CREATE TABLE IF NOT EXISTS asistencias (
    id_asistencia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT,
    fecha_hora DATETIME,
    FOREIGN KEY (id_socio) REFERENCES socios(id_socio)
);

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(100),
    rol VARCHAR(30)
);
