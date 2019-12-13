package testboundaries.data.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testboundaries.data.entidades.CuentaEntidad;

import java.util.Collection;

@Repository
public interface IConsultarCuentasCRUD extends CrudRepository<CuentaEntidad,Integer> {

    Collection<CuentaEntidad> findAll();

}
