package casosUso;


import inputs.ConsultarCursoCantidadMinimaInscriptosInput;
import modelo.Curso;
import repositorios.IRepositorioConsultarCursos;

public class ConsultarCursoCantidadMinimaInscriptosCasoUso implements ConsultarCursoCantidadMinimaInscriptosInput {

    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ConsultarCursoCantidadMinimaInscriptosCasoUso(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }

    @Override
    public Curso ConsultarCursoCantidadMinimaInscriptos() {

        Curso cursoMinimoInscriptos = null;
        int min = Integer.MAX_VALUE;

        for(Curso curso : this.iRepositorioConsultarCursos.findAll()){
            if(curso.getInscriptos() != null){
                if(curso.getInscriptos().size() < min){
                    min = curso.getInscriptos().size();
                    cursoMinimoInscriptos = curso;
                }
            }
        }
        return cursoMinimoInscriptos;

    }
}
