package strategy;

import controller.CajeroController;

public class SalirSesion implements OperacionCajero {
    private CajeroController controller;

    public SalirSesion(CajeroController controller) {
        this.controller = controller;
    }

    @Override
    public void ejecutar() {
        controller.cerrarSesion();
    }
}