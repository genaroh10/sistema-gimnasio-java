import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Gestión de Gimnasio");

        try (Connection con = Conexion.conectar()) {
            if (con != null) {
                System.out.println("Conexión con MySQL realizada correctamente");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
