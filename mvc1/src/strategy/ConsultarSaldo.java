package strategy;

import controller.CajeroController;

public class ConsultarSaldo implements OperacionCajero {
    private CajeroController controller;

    public ConsultarSaldo(CajeroController controller) {
        this.controller = controller;
    }

    @Override
    public void ejecutar() {
        controller.consultarSaldo();
    }
}
