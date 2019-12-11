package inputs;

import excepciones.CuentaIncompletaException;
import excepciones.UpdateCuentaException;
import modelo.Cuenta;

public interface EditarCuentaInput {
    Cuenta EditarCuenta(Cuenta cuentaDatosNuevos) throws CuentaIncompletaException, UpdateCuentaException;
}
