package adaptadores;

import dto.CuentaDTO;
import factorys.CuentaFactory;
import inputs.ConsultarCuentasInput;
import modelo.Cuenta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConsultarCuentasAdapter {

    private ConsultarCuentasInput consultarCuentasInput;

    public ConsultarCuentasAdapter(ConsultarCuentasInput consultarCuentasInput) {
        this.consultarCuentasInput = consultarCuentasInput;
    }

    public Collection<CuentaDTO> ConsultarCuentas(){

        List<CuentaDTO> listaCuentas = new ArrayList<>();

        this.consultarCuentasInput.ConsultarCuentas().forEach(c -> listaCuentas.add(CuentaFactory.mapeoCoreDTO(c)));

        return listaCuentas;

    }


}
