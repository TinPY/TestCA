package adaptadores;

import dto.CuentaDTO;
import excepciones.CuentaExisteException;
import excepciones.CuentaIncompletaException;
import factorys.CuentaFactory;
import inputs.CrearCuentaInput;

public class CrearCuentaAdapter {

    private CrearCuentaInput crearCuentaInput;

    public CrearCuentaAdapter(CrearCuentaInput crearCuentaInput){
        this.crearCuentaInput = crearCuentaInput;
    }

    public boolean CrearCuenta(CuentaDTO cuentaDTO) throws CuentaExisteException {
        return this.crearCuentaInput.CrearCuenta(CuentaFactory.mapeoDTOaCore(cuentaDTO));
    }

}
