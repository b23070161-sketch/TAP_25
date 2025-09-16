package Model;

public class Paypal implements MetodoPago
{
    @Override
    public <T> void procesarPago(T datos) {
        System.out.println("Procesando pago con PayPal: " + datos);
    }
}
