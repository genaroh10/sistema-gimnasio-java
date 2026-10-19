# Sistema de Gestión de Gimnasio - TP3

Prototipo en Java con persistencia MySQL desarrollado para la tercera entrega del proyecto.

## Funcionalidades implementadas

- Conexión Java-MySQL mediante JDBC.
- Registro de socios.
- Registro de pagos.
- Listado de socios usando `ArrayList<Socio>`.
- Búsqueda lineal de socios por DNI.
- Menú de selección con `do-while`, `switch` e `if`.
- Manejo de excepciones.
- Uso de constructores y creación de objetos.
- Encapsulamiento, abstracción, herencia y polimorfismo.

## Clases principales

- `Conexion`: administra la conexión con MySQL.
- `Socio`: representa y persiste socios.
- `Pago`: clase abstracta base para los pagos.
- `PagoEfectivo`: especialización de `Pago`.
- `PagoTransferencia`: especialización de `Pago`.
- `Main`: contiene el menú principal y coordina las operaciones.

## Configuración

1. Ejecutar `gimnasio.sql` en MySQL.
2. Agregar MySQL Connector/J al proyecto de Visual Studio Code.
3. Revisar usuario y contraseña en `Conexion.java`.
4. Ejecutar `Main.java`.


