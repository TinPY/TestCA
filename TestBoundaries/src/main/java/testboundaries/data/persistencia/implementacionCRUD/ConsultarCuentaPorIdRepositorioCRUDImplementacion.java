package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioConsultarCuentaPorId;
import repositorios.IRepositorioConsultarCuentaPorUsuario;
import testboundaries.data.entidades.CuentaEntidad;
import testboundaries.data.mapeadores.CuentaMapeador;
import testboundaries.data.persistencia.IConsultarCuentaPorIdCRUD;
import testboundaries.data.persistencia.IConsultarCuentaPorUsuarioRepositorioCRUD;

@Service
public class ConsultarCuentaPorIdRepositorioCRUDImplementacion implements IRepositorioConsultarCuentaPorId {

    @Autowired
    IConsultarCuentaPorIdCRUD iConsultarCuentaPorIdCRUD;

    @Override
    public Cuenta findByIdCuenta(Integer idCuenta) {
        CuentaEntidad cuentaEntidad = this.iConsultarCuentaPorIdCRUD.findByIdCuenta(idCuenta);

        if(cuentaEntidad != null){
            return CuentaMapeador.mapeoDataCore(cuentaEntidad);
        }
        return null;
    }
}
