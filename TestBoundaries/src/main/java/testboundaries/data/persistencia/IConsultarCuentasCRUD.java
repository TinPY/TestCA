package testboundaries.data.persistencia;

import org.springframework.data.repository.CrudRepository;
import testboundaries.data.entidades.CuentaEntidad;

import java.util.Collection;

public interface IConsultarCuentasCRUD extends CrudRepository<CuentaEntidad,Integer> {

    Collection<CuentaEntidad> findAll();

}
