CREATE DATABASE IF NOT EXISTS gimnasio;
USE gimnasio;

CREATE TABLE IF NOT EXISTS socios (
    id_socio INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    dni VARCHAR(20) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    email VARCHAR(100),
    fecha_alta DATE
);

CREATE TABLE IF NOT EXISTS pagos (
    id_pago INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    fecha_pago DATE NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    metodo_pago VARCHAR(30) NOT NULL,
    FOREIGN KEY (id_socio) REFERENCES socios(id_socio)
);

CREATE TABLE IF NOT EXISTS asistencias (
    id_asistencia INT PRIMARY KEY AUTO_INCREMENT,
    id_socio INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    FOREIGN KEY (id_socio) REFERENCES socios(id_socio)
);

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rol VARCHAR(30) NOT NULL
);
