package strategy;

import controller.CajeroController;

public class RealizarRetiro implements OperacionCajero {
    private CajeroController controller;

    public RealizarRetiro(CajeroController controller) {
        this.controller = controller;
    }

    @Override
    public void ejecutar() {
        controller.realizarRetiro();
    }
}
