import java.sql.Connection;
import java.sql.PreparedStatement;

public class Socio {

    private int idSocio;
    private String nombre;
    private String apellido;
    private String dni;

    public Socio(int idSocio, String nombre, String apellido, String dni) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void registrar() {
        String sql = "INSERT INTO socios(nombre, apellido, dni) VALUES (?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.executeUpdate();

            System.out.println("Socio registrado");

        } catch (Exception e) {
            System.out.println("Error al registrar socio: " + e.getMessage());
        }
    }
}
