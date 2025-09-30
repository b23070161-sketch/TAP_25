package view;

import controller.CajeroController;
import model.CajeroModel;

public class CajeroAutomatico
{
    public static void main(String[] args)
    {
        CajeroModel model = new CajeroModel();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model, view);
        controller.IniciarSistema();
    }
}
