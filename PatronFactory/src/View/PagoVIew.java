package View;
import Controller.PagoController;

public class PagoVIew {
    private final PagoController controller = new PagoController();

    public void mostrar(){
        controller.realizarPago("tarjeta", "Numero: 123-456-789");
        controller.realizarPago("paypal", "Correo: b23070161@itcelaya.edu.mx");
        controller.realizarPago("transferencia","CLABE: 0123456789");
    }
}
