import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Sistema de Gestión de Gimnasio");
        comprobarConexion();

        int opcion = 0;

        do {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        registrarSocio();
                        break;
                    case 2:
                        registrarPago();
                        break;
                    case 3:
                        listarSocios();
                        break;
                    case 4:
                        buscarSocioPorDni();
                        break;
                    case 5:
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Dato inválido: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error de base de datos: " + e.getMessage());
            }

            System.out.println();
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Registrar socio");
        System.out.println("2. Registrar pago");
        System.out.println("3. Listar socios");
        System.out.println("4. Buscar socio por DNI");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void comprobarConexion() {
        try (Connection con = Conexion.conectar()) {
            if (con != null) {
                System.out.println("Conexión con MySQL realizada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con MySQL: " + e.getMessage());
        }

        System.out.println();
    }

    private static void registrarSocio() throws SQLException {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        System.out.print("DNI: ");
        String dni = scanner.nextLine().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
            throw new IllegalArgumentException("Nombre, apellido y DNI son obligatorios.");
        }

        Socio socio = new Socio(0, nombre, apellido, dni);
        socio.registrar();
        System.out.println("Socio registrado correctamente.");
    }

    private static void registrarPago() throws SQLException {
        System.out.print("ID del socio: ");
        int idSocio = Integer.parseInt(scanner.nextLine());

        System.out.print("Monto: ");
        double monto = Double.parseDouble(scanner.nextLine());

        System.out.println("Método de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Transferencia");
        System.out.print("Seleccione una opción: ");
        int metodo = Integer.parseInt(scanner.nextLine());

        Pago pago;

        if (metodo == 1) {
            pago = new PagoEfectivo(0, idSocio, monto);
        } else if (metodo == 2) {
            pago = new PagoTransferencia(0, idSocio, monto);
        } else {
            throw new IllegalArgumentException("Método de pago inválido.");
        }

        pago.registrarPago();
        System.out.println("Pago registrado correctamente como " + pago.obtenerMetodoPago() + ".");
    }

    private static void listarSocios() throws SQLException {
        ArrayList<Socio> socios = Socio.listarTodos();

        if (socios.isEmpty()) {
            System.out.println("No hay socios registrados.");
            return;
        }

        System.out.println("=== LISTADO DE SOCIOS ===");
        for (Socio socio : socios) {
            System.out.println(socio);
        }
    }

    private static void buscarSocioPorDni() throws SQLException {
        System.out.print("Ingrese el DNI a buscar: ");
        String dni = scanner.nextLine().trim();

        Socio socio = Socio.buscarPorDni(dni);

        if (socio != null) {
            System.out.println("Socio encontrado: " + socio);
        } else {
            System.out.println("No se encontró un socio con ese DNI.");
        }
    }
}
