package strategy;

import controller.CajeroController;

public class Transferir implements OperacionCajero {
    private CajeroController controller;

    public Transferir(CajeroController controller) {
        this.controller = controller;
    }

    @Override
    public void ejecutar() {
        controller.realizarTransferencia();
    }
}
