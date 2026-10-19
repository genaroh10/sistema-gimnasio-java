public class PagoTransferencia extends Pago {

    public PagoTransferencia(int idPago, int idSocio, double monto) {
        super(idPago, idSocio, monto);
    }

    @Override
    public String obtenerMetodoPago() {
        return "Transferencia";
    }
}
