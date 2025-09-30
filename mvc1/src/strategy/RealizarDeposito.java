package strategy;

import controller.CajeroController;

public class RealizarDeposito implements OperacionCajero {
    private CajeroController controller;

    public RealizarDeposito(CajeroController controller) {
        this.controller = controller;
    }

    @Override
    public void ejecutar() {
        controller.realizarDeposito();
    }
}
