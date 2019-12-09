package testboundaries.data.persistencia;

import org.springframework.stereotype.Repository;
import testboundaries.data.entidades.CuentaEntidad;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ICrearCuentaRepositorioCRUD extends CrudRepository<CuentaEntidad, Integer> {

    CuentaEntidad save(CuentaEntidad cuentaEntidad);

}
