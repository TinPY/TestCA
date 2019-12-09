package casosUso;

import excepciones.CuentaExisteException;
import inputs.CrearCuentaInput;
import modelo.Cuenta;
import repositorios.IRepositorioConsultarCuentaPorUsuario;
import repositorios.IRepositorioCrearCuenta;

public class CrearCuentaCasoUso implements CrearCuentaInput {

    private IRepositorioCrearCuenta iRepositorioCrearCuenta;
    private IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    public CrearCuentaCasoUso(
            IRepositorioCrearCuenta iRepositorioCrearCuenta,
            IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario){
        this.iRepositorioCrearCuenta = iRepositorioCrearCuenta;
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
    }

    @Override
    public boolean CrearCuenta(Cuenta cuenta) throws CuentaExisteException {
        if(ExisteCuenta(cuenta.getNombre())){
            throw new CuentaExisteException();
        }

        return iRepositorioCrearCuenta.persist(cuenta);
    }

    private boolean ExisteCuenta(String nombre) {
        if(this.iRepositorioConsultarCuentaPorUsuario.findByUsuario(nombre) != null){
            return true;
        }
        return false;
    }
}
