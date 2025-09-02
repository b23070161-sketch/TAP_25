package VIew;
import java.util.Scanner;

public class CajeroView 
{
    private Scanner scanner;
    
    public CajeroView()
    {
        scanner = new Scanner(System.in);
    }
    public void mostrarBienvenida()
    {
        System.out.println("==========================================");
        System.out.println("    ____  _                            _     __               __                _               \n" +
"   / __ )(_)__  ____ _   _____  ____  (_)___/ /___     ____ _/ /  _________ _  (_)__  _________ \n" +
"  / __  / / _ \\/ __ \\ | / / _ \\/ __ \\/ / __  / __ \\   / __ `/ /  / ___/ __ `/ / / _ \\/ ___/ __ \\\n" +
" / /_/ / /  __/ / / / |/ /  __/ / / / / /_/ / /_/ /  / /_/ / /  / /__/ /_/ / / /  __/ /  / /_/ /\n" +
"/_____/_/\\___/_/ /_/|___/\\___/_/ /_/_/\\__,_/\\____/   \\__,_/_/   \\___/\\__,_/_/ /\\___/_/   \\____/ \n" +
"                                                                         /___/                  ");
        System.out.println("==========================================");
    }
    public String solicitarNumeroCuenta()
    {
        System.out.println("Ingrese su numero de cuenta: ");
        return scanner.nextLine();
    }
    public String solicitarPin()
    {
        System.out.println("Ingresa tu pin: ");
        return scanner.nextLine();
    }
    public void mostrarMenuPrincipal(String titular)
    {
       System.out.println("==========================================");
       System.out.println("   ___  _                       _    __     _ \n" +
"  / _ )(_)__ ___ _  _____ ___  (_)__/ /__  (_)\n" +
" / _  / / -_) _ \\ |/ / -_) _ \\/ / _  / _ \\_   \n" +
"/____/_/\\__/_//_/___/\\__/_//_/_/\\_,_/\\___(_)  \n" +
"                                                "
               + "" + titular);
       System.out.println("==========================================");
       System.out.println("1. Consultar Saldo");
       System.out.println("2. Retirar");
       System.out.println("3. Depositar");
       System.out.println("4. Cambiar NIP");
       System.out.println("5. Salir");
       System.out.println("==========================================");
       
       //SOLO METI LA OPCION DE CAMBIAR NIP
    }
    public int leerOpcion()
    {
        try {
            return Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
    }
    public void mostrarSaldo(double saldo)
    {
        System.out.println("================================");
        System.out.println("   ____     __   __                __            ___ \n" +
"  / __/__ _/ /__/ /__    ___ _____/ /___ _____ _/ (_)\n" +
" _\\ \\/ _ `/ / _  / _ \\  / _ `/ __/ __/ // / _ `/ /   \n" +
"/___/\\_,_/_/\\_,_/\\___/  \\_,_/\\__/\\__/\\_,_/\\_,_/_(_)  \n" +
"                                                      " + saldo);
        System.out.println("================================");
    }
    public double solicitarCantidad(String operacion)
    {
        System.out.println("Ingresa la cantidad a" + operacion);
        try{
            return Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }
    public void mostrarMensaje(String mensaje)
    {
        System.out.print("====== " + mensaje);
    }
    
    //tarea personalizar mensajes de error y de exito
    //tarea mateodo para salir cerrar el scanner

    public void MostrarBienvenida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
