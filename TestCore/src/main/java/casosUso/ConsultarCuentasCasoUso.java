package casosUso;

import inputs.ConsultarCuentasInput;
import modelo.Cuenta;
import repositorios.IRepositorioConsultarCuentas;

import java.util.Collection;

public class ConsultarCuentasCasoUso implements ConsultarCuentasInput {

    private IRepositorioConsultarCuentas iRepositorioConsultarCuentas;

    public ConsultarCuentasCasoUso(IRepositorioConsultarCuentas iRepositorioConsultarCuentas) {
        this.iRepositorioConsultarCuentas = iRepositorioConsultarCuentas;
    }

    @Override
    public Collection<Cuenta> ConsultarCuentas() {
        return this.iRepositorioConsultarCuentas.findAll();
    }
}
