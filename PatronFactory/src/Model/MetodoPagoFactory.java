package Model;

public class MetodoPagoFactory {
    public static MetodoPago crearMetodo(String tipo)
    {
        return switch (tipo.toLowerCase()){
            case "tarjeta"  -> new Tarjeta();
            case "paypal" -> new Paypal();
            case "transferencia" -> new Transferencia();
            default -> throw new IllegalArgumentException("No se encontro el tipo de pago");
        };
    }
}
