package Controller;

import Model.CajeroModel;
import VIew.CajeroView;

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

    private void ejecutarMenuPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
