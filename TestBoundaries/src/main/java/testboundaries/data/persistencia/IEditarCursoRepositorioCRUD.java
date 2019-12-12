package testboundaries.data.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testboundaries.data.entidades.CursoEntidad;

@Repository
public interface IEditarCursoRepositorioCRUD extends CrudRepository<CursoEntidad, Integer> {

    CursoEntidad save(CursoEntidad cursoEntidad);
}
