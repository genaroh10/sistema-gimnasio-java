import java.sql.Connection;
import java.sql.PreparedStatement;

public class Pago {

    private int idPago;
    private int idSocio;
    private double monto;

    public Pago(int idPago, int idSocio, double monto) {
        this.idPago = idPago;
        this.idSocio = idSocio;
        this.monto = monto;
    }

    public void registrarPago() {
        String sql = "INSERT INTO pagos(id_socio, monto) VALUES (?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idSocio);
            ps.setDouble(2, monto);
            ps.executeUpdate();

            System.out.println("Pago registrado");

        } catch (Exception e) {
            System.out.println("Error al registrar pago: " + e.getMessage());
        }
    }
}
