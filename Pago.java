import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Pago {
    private int idPago;
    private int idSocio;
    private double monto;

    public Pago(int idPago, int idSocio, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        this.idPago = idPago;
        this.idSocio = idSocio;
        this.monto = monto;
    }

    public int getIdPago() {
        return idPago;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public double getMonto() {
        return monto;
    }

    public abstract String obtenerMetodoPago();

    public void registrarPago() throws SQLException {
        String sql = "INSERT INTO pagos(id_socio, fecha_pago, monto, metodo_pago) VALUES (?, CURDATE(), ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idSocio);
            ps.setDouble(2, monto);
            ps.setString(3, obtenerMetodoPago());
            ps.executeUpdate();
        }
    }
}
