package practica1cajero;

import java.util.Scanner;

public class Cajero
{
    private Cliente[] clientes;
    private Scanner scanner;
    private int usuarioActual;

    public Cajero() 
    {
        scanner = new Scanner(System.in);
        clientes = new Cliente[2];
        clientes[0] = new Cliente("1234", "Juan", 1000.0);
        clientes[1] = new Cliente("5678", "Maria", 2500.0);
        usuarioActual = -1;
    }

    public void iniciar() 
    {
        int intentos = 0;
        boolean salir = false;
        System.out.println("==================================================================================================");
        System.out.println("  ____  _                           _     _               _             _                \n" +
" |  _ \\(_)                         (_)   | |             | |           (_)               \n" +
" | |_) |_  ___ _ ____   _____ _ __  _  __| | ___     __ _| |   ___ __ _ _  ___ _ __ ___  \n" +
" |  _ <| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\   / _` | |  / __/ _` | |/ _ \\ '__/ _ \\ \n" +
" | |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) | | (_| | | | (_| (_| | |  __/ | | (_) |\n" +
" |____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/   \\__,_|_|  \\___\\__,_| |\\___|_|  \\___/ \n" +
"                                                                      _/ |               \n" +
"                                                                     |__/                ");
        System.out.println("==================================================================================================");

        while (intentos < 3 && usuarioActual == -1)
        {
            System.out.print("Ingrese su Pin: ");
            String pinIngresado = scanner.nextLine();

            for (int i = 0; i < clientes.length; i++) 
            {
                if (clientes[i].getPin().equals(pinIngresado)) 
                {
                    usuarioActual = i;
                    break;
                }
            }

            if (usuarioActual == -1)
            {
                System.out.println("PIN incorrectoo.");
                intentos++;
            }
        }

        if (usuarioActual == -1)
        {
            System.out.println("Demasiados intentos fallidos. Adiós.");
            return;
        }

        System.out.println("Bienvenido, " + clientes[usuarioActual].getNombre());

        while (!salir)
        {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1)
            {
                System.out.println("Su saldo es: $" + clientes[usuarioActual].getSaldo());
            } 
            else if (opcion == 2)
            {
                System.out.print("Ingrese cantidad a retirar: ");
                double retiro = scanner.nextDouble();
                if (clientes[usuarioActual].retirar(retiro)) 
                {
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + clientes[usuarioActual].getSaldo());
                }
                else 
                {
                    System.out.println("Fondos insuficientes.");
                }
            } 
            else if (opcion == 3) 
            {
                System.out.print("Ingrese cantidad a depositar: ");
                double deposito = scanner.nextDouble();
                clientes[usuarioActual].depositar(deposito);
                System.out.println("Depósito exitoso. Nuevo saldo: $" + clientes[usuarioActual].getSaldo());
            } 
            else if (opcion == 4) 
            {
                salir = true;
                System.out.println("=============================================================================================================");
                System.out.println("   ___             _                                                   _            _               ___  \n" +
"  / __|_ _ __ _ __(_)__ _ ___  _ __  ___ _ _   _  _ ___ __ _ _ _   ___| |  __ __ _ (_)___ _ _ ___  (_) \\ \n" +
" | (_ | '_/ _` / _| / _` (_-< | '_ \\/ _ \\ '_| | || (_-</ _` | '_| / -_) | / _/ _` || / -_) '_/ _ \\  _ | |\n" +
"  \\___|_| \\__,_\\__|_\\__,_/__/ | .__/\\___/_|    \\_,_/__/\\__,_|_|   \\___|_| \\__\\__,_|/ \\___|_| \\___/ (_)| |\n" +
"                              |_|                                                |__/                /_/ ");
                System.out.println("==============================================================================================================");
            } 
            else
            {
                System.out.println("Opción inválida.");
            }
        }
    }
}