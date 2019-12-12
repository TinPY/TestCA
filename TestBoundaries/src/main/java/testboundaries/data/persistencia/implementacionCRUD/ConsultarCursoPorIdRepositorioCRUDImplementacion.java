package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioConsultarCursoPorId;
import testboundaries.data.entidades.CursoEntidad;
import testboundaries.data.mapeadores.CursoMapeador;
import testboundaries.data.persistencia.IConsultarCursoPorIdCRUD;

@Service
public class ConsultarCursoPorIdRepositorioCRUDImplementacion implements IRepositorioConsultarCursoPorId {

    @Autowired
    IConsultarCursoPorIdCRUD iConsultarCursoPorIdCRUD;

    @Override
    public Curso findByIdCurso(Integer idCurso) {

        CursoEntidad cursoEntidad = this.iConsultarCursoPorIdCRUD.findByIdCurso(idCurso);

        if(cursoEntidad != null){
            return CursoMapeador.mapearEntidadCore(cursoEntidad);
        }
        return null;
    }
}
