package StrategySample;

public interface PagoStrategy {
    void pagar(double monto);
}

class PagoTarjeta implements PagoStrategy {
    @Override
    public void pagar(double monto) {
        System.out.println("pagando " + monto + " con tarjeta de credito.");
    }
}

class PagoPayPal implements PagoStrategy {
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando " + monto + " usando PayPal.");
    }
}

class PagoEfectivo implements PagoStrategy {
    @Override
    public void pagar(double monto) {
        System.out.println("Pagando  " + monto + " en efectivo.");
    }
}

class Carrito {
    private PagoStrategy estrategia;
    
    public Carrito(PagoStrategy estrategia) {
        this.estrategia = estrategia;
    }
    
    public void setEstrategia(PagoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void pagar(double monto) {
        estrategia.pagar(monto);
    }
}
