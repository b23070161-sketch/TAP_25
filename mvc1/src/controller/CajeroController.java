package controller;

import model.CajeroModel;
import view.CajeroView;
import strategy.*;

import java.util.HashMap;
import java.util.Map;

public class CajeroController {
    private CajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;
    private boolean sessionActiva;
    private Map<Integer, OperacionCajero> operaciones;

    public CajeroController(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
        this.operaciones = new HashMap<>();

        //========================================== STRATEGIES =========================================================//
        operaciones.put(1, new ConsultarSaldo(this));
        operaciones.put(2, new RealizarRetiro(this));
        operaciones.put(3, new RealizarDeposito(this));
        operaciones.put(9, new SalirSesion(this));
        operaciones.put(4, new Transferir(this));  // ejemplo: opción 4 = Transferir

    }

    public void IniciarSistema() {
        view.mostrarBienvenida();
        while (sistemaActivo) {
            if (autenticarUsuario()) {
                ejecutarMenuPrincipal();
            } else {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar el cajero");
    }

    private boolean autenticarUsuario() {
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta, pin);
    }

    private void ejecutarMenuPrincipal() {
        this.sessionActiva = true;
        while (this.sessionActiva) {
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();

            OperacionCajero operacion = operaciones.get(opcion);
            if (operacion != null) {
                operacion.ejecutar();
            } else {
                view.mostrarMensaje("Opción inválida");
            }
        }
    }

    public void cerrarSesion() {
        view.mostrarMensaje("Cerrando sesión...");
        this.sessionActiva = false;
    }

    public void consultarSaldo() {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }

    public void realizarRetiro() {
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad <= 0) {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarRetiro(cantidad)) {
            view.mostrarMensaje("Retiro exitoso de " + cantidad);
        } else {
            view.mostrarMensaje("Fondos insuficientes");
        }
    }

    public void realizarDeposito() {
        double cantidad = view.solicitarCantidad("Deposito");
        if (cantidad <= 0) {
            view.mostrarMensaje("Error al procesar el depósito");
            return;
        }
        // supongamos model.realizarDeposito devuelve boolean (ajusta si tu modelo usa void)
        if (model.realizarDeposito(cantidad)) {
            view.mostrarMensaje("Depósito exitoso por la cantidad de " + cantidad);
        } else {
            view.mostrarMensaje("Error al procesar el depósito");
        }
    }

    public void realizarTransferencia() {
        String cuentaDestino = view.solicitarNumeroCuentaDestino();
        double monto = view.solicitarCantidad("Transferir");

        if (monto <= 0) {
            view.mostrarMensaje("Cantidad inválida");
            return;
        }

        if (model.realizarTransferencia(cuentaDestino, monto)) {
            view.mostrarMensaje("Transferencia exitosa de " + monto + " a la cuenta " + cuentaDestino);
        } else {
            view.mostrarMensaje("Error en la transferencia (fondos insuficientes o cuenta inválida).");
        }
    }
}
