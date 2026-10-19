import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public int getIdSocio() {
        return idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public void registrar() throws SQLException {
        String sql = "INSERT INTO socios(nombre, apellido, dni, fecha_alta) VALUES (?, ?, ?, CURDATE())";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.executeUpdate();
        }
    }

    public static ArrayList<Socio> listarTodos() throws SQLException {
        ArrayList<Socio> socios = new ArrayList<>();
        String sql = "SELECT id_socio, nombre, apellido, dni FROM socios ORDER BY apellido, nombre";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Socio socio = new Socio(
                        rs.getInt("id_socio"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni")
                );
                socios.add(socio);
            }
        }

        return socios;
    }

    public static Socio buscarPorDni(String dniBuscado) throws SQLException {
        ArrayList<Socio> socios = listarTodos();

        for (Socio socio : socios) {
            if (socio.getDni().equalsIgnoreCase(dniBuscado)) {
                return socio;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return idSocio + " - " + nombre + " " + apellido + " - DNI: " + dni;
    }
}
