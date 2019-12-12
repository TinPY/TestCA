package casosUso;

import inputs.ConsultarCursosInput;
import modelo.Curso;
import repositorios.IRepositorioConsultarCursos;

import java.util.Collection;

public class ConsultarCursosCasoUso implements ConsultarCursosInput {

    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ConsultarCursosCasoUso(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }

    @Override
    public Collection<Curso> ConsultarCursos() {

        return this.iRepositorioConsultarCursos.findAll();

    }
}
