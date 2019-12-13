package testboundaries.data.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testboundaries.data.entidades.CursoEntidad;

import java.util.Collection;

@Repository
public interface IConsultarCursosCRUD extends CrudRepository<CursoEntidad,Integer> {

    Collection<CursoEntidad> findAll();

}
