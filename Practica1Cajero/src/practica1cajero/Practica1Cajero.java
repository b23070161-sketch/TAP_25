package practica1cajero;
import java.util.Scanner;

public class Practica1Cajero
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String[] usuarios = {"1234", "5678"};
        String[] nombres = {"Juan", "Maria"};
        double[] saldos = {1000.0, 2500.0};
        int intentos = 0;
        boolean salir = false;
        int usuarioActual = -1;

        System.out.println("  ____  _                           _     _               _    _____      _                \n" +
" |  _ \\(_)                         (_)   | |             | |  / ____|    (_)               \n" +
" | |_) |_  ___ _ ____   _____ _ __  _  __| | ___     __ _| | | |     __ _ _  ___ _ __ ___  \n" +
" |  _ <| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\   / _` | | | |    / _` | |/ _ \\ '__/ _ \\ \n" +
" | |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) | | (_| | | | |___| (_| | |  __/ | | (_) |\n" +
" |____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/   \\__,_|_|  \\_____\\__,_| |\\___|_|  \\___/ \n" +
"                                                                        _/ |               \n" +
"                                                                       |__/                ");

        while (intentos < 3 && usuarioActual == -1) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].equals(pin)) {
                    usuarioActual = i;
                    break;
                }
            }
            if (usuarioActual == -1) {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
        }

        if (usuarioActual == -1) {
            System.out.println("Demasiados intentos fallidos. Adiós.");
            return;
        }

        System.out.println("Bienvenido, " + nombres[usuarioActual]);

        while (!salir) {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (opcion == 1) {
                System.out.println("Su saldo es: $" + saldos[usuarioActual]);
            } else if (opcion == 2) {
                System.out.print("Ingrese cantidad a retirar: ");
                double retiro = scanner.nextDouble();
                if (retiro <= saldos[usuarioActual]) {
                    saldos[usuarioActual] -= retiro;
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldos[usuarioActual]);
                } else {
                    System.out.println("Fondos insuficientes.");
                }
            } else if (opcion == 3) {
                System.out.print("Ingrese cantidad a depositar: ");
                double deposito = scanner.nextDouble();
                saldos[usuarioActual] += deposito;
                System.out.println("Depósito exitoso. Nuevo saldo: $" + saldos[usuarioActual]);
            } else if (opcion == 4) {
                salir = true;
                System.out.println("Gracias por usar el cajero.");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    
}
