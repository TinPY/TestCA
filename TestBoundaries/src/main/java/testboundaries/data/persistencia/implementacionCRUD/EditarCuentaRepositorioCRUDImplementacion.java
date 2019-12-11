package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioEditarCuenta;
import testboundaries.data.mapeadores.CuentaMapeador;
import testboundaries.data.persistencia.IEditarCuentaRepositorioCRUD;

@Service
public class EditarCuentaRepositorioCRUDImplementacion implements IRepositorioEditarCuenta {

    @Autowired
    IEditarCuentaRepositorioCRUD iEditarCuentaRepositorioCRUD;

    @Override
    public boolean update(Cuenta cuenta) {
        if(this.iEditarCuentaRepositorioCRUD.save(CuentaMapeador.mapearCoreEntidad(cuenta)) != null){
            return true;
        }
        return false;
    }


}
