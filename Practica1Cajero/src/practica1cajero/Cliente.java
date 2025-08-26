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
    
    public String getPin() 
    {
        return pin;
    }
    
    public String getNombre() 
    {
        return nombre;
    }
    
    public double getSaldo() 
    {
        return saldo;
    }
    
    public void depositar(double cantidad)
    {
        saldo += cantidad;
    }
    
    public boolean retirar(double cantidad)
    {
        if (cantidad <= saldo)
        {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
}
