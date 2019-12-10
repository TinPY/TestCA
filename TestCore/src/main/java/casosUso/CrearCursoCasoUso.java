package casosUso;


import inputs.CrearCursoInput;
import modelo.Curso;
import repositorios.IRepositorioCrearCurso;

public class CrearCursoCasoUso implements CrearCursoInput {

    private IRepositorioCrearCurso iRepositorioCrearCurso;

    public CrearCursoCasoUso(IRepositorioCrearCurso iRepositorioCrearCurso) {
        this.iRepositorioCrearCurso = iRepositorioCrearCurso;
    }


    @Override
    public boolean CrearCurso(Curso curso) {
        return this.iRepositorioCrearCurso.persist(curso);
    }
}
