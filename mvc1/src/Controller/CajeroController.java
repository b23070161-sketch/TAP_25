package Controller;

import Model.CajeroModel;
import VIew.CajeroView;
import Model.Cuenta;

public class CajeroController 
{
    private CajeroModel Model;
    private CajeroView view;
    private boolean sistemaActivo;
    private final CajeroModel model;
    
    public CajeroController(CajeroModel model, CajeroView view)
    {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }
    public void IniciarSistema()
    {
        view.MostrarBienvenida();
        while(sistemaActivo)
        {
            if(autenticarUsuario())
            {
                ejecutarMenuPrincipal();
            }
            else
            {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar el cajero");
    }
    private boolean autenticarUsuario()
    {
        
        return false;
        
    }
    private void ejecutarMenuPrincipal()
    {
        boolean sessionActiva = true;
        while (sessionActiva)
        {
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();
            switch(opcion)
            {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    realizarRetiro();
                    break;
                case 3:
                    break;
                case 9:
                    break;
                default:
                    break;
                
                
            }
        }
    }
    
    public void consultarSaldo()
    {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }
    
    public void realizarRetiro()
    {
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad <=0 )
        {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarRetiro(cantidad))
        {
            view.mostrarMensaje("Retiro exitoso de " + cantidad);
        }
        else
        {
            view.mostrarMensaje("Fondos insuficientes");
        }
    }
    
    public void realizarDeposito()
    {
        double cantidad = view.solicitarCantidad("Deposito");
        if (cantidad <= 0)
        {
            view.mostrarMensaje("Deposito exitoso por la cantidad de " + cantidad);
        }
        else
        {
            view.mostrarMensaje("Error al procesar el deposito");
        }
    }
}
