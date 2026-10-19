public class PagoEfectivo extends Pago {

    public PagoEfectivo(int idPago, int idSocio, double monto) {
        super(idPago, idSocio, monto);
    }

    @Override
    public String obtenerMetodoPago() {
        return "Efectivo";
    }
}
