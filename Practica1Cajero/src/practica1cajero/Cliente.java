package practica1cajero;

public class Cliente 
{
    private String pin, nombre;
    private double saldo;
    
    public Cliente(String pin, String nombre, double saldo)
    {
        this.pin = pin;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(double cantidad)
    {
        saldo += cantidad;
    }
    public boolean retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        } else {
            return false;
        }
    }
}
