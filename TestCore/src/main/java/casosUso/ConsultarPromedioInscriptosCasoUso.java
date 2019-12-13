package casosUso;

import inputs.ConsultarPromedioInscriptosInput;
import modelo.Curso;
import repositorios.IRepositorioConsultarCursos;

import java.util.List;

public class ConsultarPromedioInscriptosCasoUso implements ConsultarPromedioInscriptosInput {

    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ConsultarPromedioInscriptosCasoUso(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }

    @Override
    public Float ConsultarPromedioInscriptos() {

        List<Curso> listaCursos = (List<Curso>) this.iRepositorioConsultarCursos.findAll();
        Integer acumulador = 0;
        Integer cantidad = listaCursos.size();
        Float promedio = 0f;

        for(Curso curso : listaCursos){
            if(curso.getInscriptos() != null){
                acumulador += curso.getInscriptos().size();
            }
        }

        promedio = (float) acumulador / cantidad;

        return promedio;

    }
}
