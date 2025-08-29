package Model;
import java.util.HashMap;
import java.util.Map;

public class CajeroModel 
{
    private Map<String, Cuenta> cuentas;
    
    private Cuenta cuentaActual;
    
    public CajeroModel()
    {
        cuentas = new HashMap();
        inicializarCuentas();
    }
    private void inicializarCuentas()
    {
        cuentas.put("12345", new Cuenta(numeroCuenta: "1234", pin:"1111", saldoInicial: 5000, titular: "Juan Perez"));
        
        cuentas.put("56789", new Cuenta(numeroCuenta: "56789", pin:"2222", saldoInicial: 2000, titular: "Maria Antonieta"));
        
        cuentas.put("1789", new Cuenta(numeroCuenta: "1789", pin:"0000", saldoInicial: 1987, titular: "Mencho"));
    }
    
    public boolean autenticar(String numeroCuenta, String pin)
    {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin))
        {
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }
    public Cuenta getCuentaActual()
    {
        return this.cuentaActual;
    }
    public double consultarSaldo()
    {
        return this.cuentaActual != null ? cuentaActual.getSaldo():0;
    }
    public boolean realizarRetiro(double cantidad)
    {
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    public boolean realizarDeposito(double cantidad)
    {
        if (cuentaActual != null && cantidad > 0)
        {
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }
    public boolean cuentaExistente(String numeroCuenta)
    {
        return cuentas.containsKey(numeroCuenta);
    }
}
