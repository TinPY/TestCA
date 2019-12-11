package adaptadores;

import dto.CuentaDTO;
import excepciones.CuentaIncompletaException;
import excepciones.UpdateCuentaException;
import factorys.CuentaFactory;
import inputs.EditarCuentaInput;
import modelo.Cuenta;

public class EditarCuentaAdapter {

    private EditarCuentaInput editarCuentaInput;

    public EditarCuentaAdapter(EditarCuentaInput editarCuentaInput) {
        this.editarCuentaInput = editarCuentaInput;
    }

    public Cuenta EditarCuenta(CuentaDTO cuentaDTO) throws CuentaIncompletaException, UpdateCuentaException {
        return this.editarCuentaInput.EditarCuenta(CuentaFactory.mapeoDTOaCore(cuentaDTO));
    }
}
