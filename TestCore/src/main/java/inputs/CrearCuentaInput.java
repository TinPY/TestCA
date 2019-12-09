package inputs;

import excepciones.CuentaExisteException;
import modelo.Cuenta;

public interface CrearCuentaInput {

    boolean CrearCuenta(Cuenta cuenta) throws CuentaExisteException;

}
