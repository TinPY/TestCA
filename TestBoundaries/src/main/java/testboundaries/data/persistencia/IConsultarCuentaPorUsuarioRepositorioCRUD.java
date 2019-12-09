package testboundaries.data.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testboundaries.data.entidades.CuentaEntidad;

@Repository
public interface IConsultarCuentaPorUsuarioRepositorioCRUD extends CrudRepository<CuentaEntidad, Integer> {

    CuentaEntidad findByUsuario(String usuario);

}
