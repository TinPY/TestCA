package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioConsultarCuentaPorUsuario;
import testboundaries.data.entidades.CuentaEntidad;
import testboundaries.data.mapeadores.CuentaMapeador;
import testboundaries.data.persistencia.IConsultarCuentaPorUsuarioRepositorioCRUD;

@Service
public class ConsultarCuentaPorUsuarioRepositorioCRUDImplementacion implements IRepositorioConsultarCuentaPorUsuario {

    @Autowired
    IConsultarCuentaPorUsuarioRepositorioCRUD iConsultarCuentaPorUsuarioRepositorioCRUD;

    @Override
    public Cuenta findByUsuario(String usuario) {
        CuentaEntidad cuentaEntidad = this.iConsultarCuentaPorUsuarioRepositorioCRUD.findByUsuario(usuario);
        if(cuentaEntidad != null){
            return CuentaMapeador.mapeoEntidadCore(cuentaEntidad);
        }
        return null;
    }

}
