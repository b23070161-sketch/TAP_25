package Controller;

public class CajeroController 
{
    private CajeroModel Model;
    private CajeroView view;
    private boolean sistemaActivo;
    
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
        
    }
}
