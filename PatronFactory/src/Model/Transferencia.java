package Model;

public class Transferencia implements MetodoPago{
    @Override
    public <T> void procesarPago(T datos) {
        System.out.println("Procesando pago con PayPal: " + datos);
    }
}
