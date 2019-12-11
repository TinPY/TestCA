package casosUso;

import excepciones.CuentaIncompletaException;
import excepciones.UpdateCuentaException;
import inputs.EditarCuentaInput;
import modelo.Cuenta;
import repositorios.IRepositorioConsultarCuentaPorId;
import repositorios.IRepositorioEditarCuenta;

public class EditarCuentaCasoUso implements EditarCuentaInput {

    private IRepositorioEditarCuenta iRepositorioEditarCuenta;
    private IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    public EditarCuentaCasoUso(IRepositorioEditarCuenta iRepositorioEditarCuenta, IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId) {
        this.iRepositorioEditarCuenta = iRepositorioEditarCuenta;
        this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
    }

    @Override
    public Cuenta EditarCuenta(Cuenta cuentaDatosNuevos) throws CuentaIncompletaException, UpdateCuentaException {

        Cuenta cuentaAModificar = iRepositorioConsultarCuentaPorId.findByIdCuenta(cuentaDatosNuevos.getIdCuenta());
        cuentaAModificar.modificarDatos(cuentaDatosNuevos);

        if(iRepositorioEditarCuenta.update(cuentaAModificar)){
            return cuentaAModificar;
        }else{
            throw new UpdateCuentaException();
        }
    }

}
