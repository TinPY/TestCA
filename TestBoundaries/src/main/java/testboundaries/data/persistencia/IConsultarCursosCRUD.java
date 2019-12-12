package testboundaries.data.persistencia;

import org.springframework.data.repository.CrudRepository;
import testboundaries.data.entidades.CursoEntidad;

import java.util.Collection;

public interface IConsultarCursosCRUD extends CrudRepository<CursoEntidad,Integer> {

    Collection<CursoEntidad> findAll();

}
