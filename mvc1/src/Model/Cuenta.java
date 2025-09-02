package Model;

public class Cuenta 
{
    private String numeroCuenta, pin, titular;
    private double saldo;
    
    public Cuenta(String numeroCuenta, String pin, double saldoInicial, String titular)
    {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldoInicial;
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getPin() {
        return pin;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public boolean validarPin(String pinIngresado)
    {
        return this.pin.equals(pinIngresado);
    }
    
    public boolean retirar(double cantidad)
    {
        if(cantidad > 0 && cantidad <= this.saldo)
        {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    public void depositar(double cantidad)
    {
        if (cantidad > 0)
        {
            saldo += cantidad;
        }
    }
    //diseñar los comportamientos restantes
    
}

//reglas de negocio. 








