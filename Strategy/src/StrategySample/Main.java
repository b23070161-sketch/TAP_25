package StrategySample;

public class Main {
    public static void main(String[] args) {
        
        Carrito carrito = new Carrito(new PagoTarjeta());
        carrito.pagar(100);
        
        carrito.setEstrategia(new PagoPayPal());
        carrito.pagar(200);

        carrito.setEstrategia(new PagoEfectivo());
        carrito.pagar(50);
    }
}