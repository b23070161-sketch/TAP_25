package model;
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
        cuentas.put("1234", new Cuenta("1234", "1234", 50000.80, "Juan N."));
        
        cuentas.put("4567", new Cuenta("4567", "4567", 8000, "Maria Magdalena"));
        
        cuentas.put("0000", new Cuenta("0000", "0000", 1987, "Omar Chaparro"));
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

    public boolean realizarTransferencia(String cuentaDestino, double monto) {
        if (cuentaActual != null && monto > 0 && cuentaActual.getSaldo() >= monto) {
            Cuenta destino = buscarCuentaPorNumero(cuentaDestino);

            if (destino != null && !destino.getNumeroCuenta().equals(cuentaActual.getNumeroCuenta())) {
                cuentaActual.retirar(monto);
                destino.depositar(monto);
                return true;
            }
        }
        return false;
    }

    public Cuenta buscarCuentaPorNumero(String numeroCuenta) {
        return cuentas.get(numeroCuenta); // devuelve null si no existe
    }
}
