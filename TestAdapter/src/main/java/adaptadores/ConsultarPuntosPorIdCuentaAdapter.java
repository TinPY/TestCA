package adaptadores;

import inputs.ConsultarPuntosPorIdCuentaInput;

public class ConsultarPuntosPorIdCuentaAdapter {

    private ConsultarPuntosPorIdCuentaInput consultarPuntosPorIdCuentaInput;

    public ConsultarPuntosPorIdCuentaAdapter(ConsultarPuntosPorIdCuentaInput consultarPuntosPorIdCuentaInput) {
        this.consultarPuntosPorIdCuentaInput = consultarPuntosPorIdCuentaInput;
    }

    public Integer ConsultarPuntosPorIdCuenta(Integer idCuenta){
        return this.consultarPuntosPorIdCuentaInput.ConsultarPuntosPorIdCuenta(idCuenta);
    }
}
