package Model;

public class Tarjeta implements MetodoPago
{
    @Override
    public <T> void procesarPago(T datos) {
        System.out.println("Procesando pago con tarjeta: " + datos);
    }
}
