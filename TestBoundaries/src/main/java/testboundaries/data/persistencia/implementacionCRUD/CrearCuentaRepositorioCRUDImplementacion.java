package testboundaries.data.persistencia.implementacionCRUD;

import org.springframework.stereotype.Service;
import testboundaries.data.mapeadores.CuentaMapeador;
import modelo.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import testboundaries.data.persistencia.ICrearCuentaRepositorioCRUD;
import repositorios.IRepositorioCrearCuenta;

@Service
public class CrearCuentaRepositorioCRUDImplementacion implements IRepositorioCrearCuenta {

    @Autowired
    ICrearCuentaRepositorioCRUD iCrearCuentaRepositorioCRUD;

    @Override
    public boolean persist(Cuenta cuenta) {
        if(this.iCrearCuentaRepositorioCRUD.save(CuentaMapeador.mapearCoreEntidad(cuenta)) != null){
            return true;
        }
        return false;
    }
}
