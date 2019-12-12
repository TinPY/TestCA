package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioConsultarCuentas;
import testboundaries.data.mapeadores.CuentaMapeador;
import testboundaries.data.persistencia.IConsultarCuentasCRUD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ConsultarCuentasRepositorioCRUDImplementacion implements IRepositorioConsultarCuentas {

    @Autowired
    IConsultarCuentasCRUD iConsultarCuentasCRUD;

    @Override
    public Collection<Cuenta> findAll() {

        List<Cuenta> cuentas = new ArrayList<>();

        this.iConsultarCuentasCRUD.findAll().forEach(c -> cuentas.add(CuentaMapeador.mapearEntidadCore(c)));

        return cuentas;

    }
}
