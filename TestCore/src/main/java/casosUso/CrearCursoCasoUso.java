package casosUso;


import excepciones.CursoFechaLimiteAnteriorException;
import inputs.CrearCursoInput;
import modelo.Curso;
import repositorios.IRepositorioCrearCurso;

import java.time.LocalDateTime;

public class CrearCursoCasoUso implements CrearCursoInput {

    private IRepositorioCrearCurso iRepositorioCrearCurso;

    public CrearCursoCasoUso(IRepositorioCrearCurso iRepositorioCrearCurso) {
        this.iRepositorioCrearCurso = iRepositorioCrearCurso;
    }


    @Override
    public boolean CrearCurso(Curso curso) throws CursoFechaLimiteAnteriorException {

        if(curso.getFechaLimiteInscripcion().isBefore(LocalDateTime.now().withHour(0).withMinute(0))){
			throw new CursoFechaLimiteAnteriorException();
		}

        // Se crean los Cursos sin Inscriptos
        if(!curso.getInscriptos().isEmpty()){
            curso.getInscriptos().clear();
        }

        return this.iRepositorioCrearCurso.persist(curso);
    }
}
