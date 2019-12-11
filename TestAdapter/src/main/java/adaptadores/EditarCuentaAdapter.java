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

    public CuentaDTO EditarCuenta(CuentaDTO cuentaDTO) throws CuentaIncompletaException, UpdateCuentaException {
        Cuenta cuentaEditada = editarCuentaInput.EditarCuenta(CuentaFactory.mapeoDTOaCore(cuentaDTO));
        return CuentaFactory.mapeoCoreDTO(cuentaEditada);
    }
}
