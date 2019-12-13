package casosUso;

import inputs.ConsultarCursoCantidadMaximaInscriptosInput;
import modelo.Curso;
import repositorios.IRepositorioConsultarCursos;

public class ConsultarCursoCantidadMaximaInscriptosCasoUso implements ConsultarCursoCantidadMaximaInscriptosInput {

    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ConsultarCursoCantidadMaximaInscriptosCasoUso(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }

    @Override
    public Curso ConsultarCursoCantidadMaximaInscriptos() {

        Curso cursoMaximoInscriptos = null;
        int max = 0;

        for(Curso curso : this.iRepositorioConsultarCursos.findAll()){
            if(curso.getInscriptos() != null){
                if(curso.getInscriptos().size() > max){
                    max = curso.getInscriptos().size();
                    cursoMaximoInscriptos = curso;
                }
            }
        }
        return cursoMaximoInscriptos;
    }
}
