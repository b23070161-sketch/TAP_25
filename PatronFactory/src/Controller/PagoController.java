package Controller;
import Model.MetodoPago;
import Model.MetodoPagoFactory;

public class PagoController {
        public void realizarPago(String tipo, Object datos){
            MetodoPago metodoPago = MetodoPagoFactory.crearMetodo(tipo);
            metodoPago.procesarPago(datos);
        }
    }
