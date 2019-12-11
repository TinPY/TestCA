package testboundaries.data.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testboundaries.data.entidades.CuentaEntidad;

@Repository
public interface IEditarCuentaRepositorioCRUD extends CrudRepository<CuentaEntidad, Integer> {

    CuentaEntidad save(CuentaEntidad cuentaEntidad);
}
