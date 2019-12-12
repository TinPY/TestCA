package casosUso;

import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.UpdateCursoException;
import excepciones.UpdateCursoFechaLimiteAnteriorException;
import inputs.EditarCursoInput;
import modelo.Curso;
import repositorios.IRepositorioConsultarCursoPorId;
import repositorios.IRepositorioEditarCurso;

import java.time.LocalDateTime;

public class EditarCursoCasoUso implements EditarCursoInput {

    private IRepositorioEditarCurso iRepositorioEditarCurso;
    private IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    public EditarCursoCasoUso(IRepositorioEditarCurso iRepositorioEditarCurso, IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId) {
        this.iRepositorioEditarCurso = iRepositorioEditarCurso;
        this.iRepositorioConsultarCursoPorId = iRepositorioConsultarCursoPorId;
    }


    @Override
    public Curso EditarCurso(Curso cursoDatosNuevos) throws UpdateCursoException, UpdateCursoFechaLimiteAnteriorException {
        Curso cursoAModificar = iRepositorioConsultarCursoPorId.findByIdCurso(cursoDatosNuevos.getIdCurso());

        // - No puede editarse un curso con fecha de limite inferior a la actual, a menos que no se haya modificado la fecha

        // Editar: La fecha ES distinta??
        if(!cursoDatosNuevos.getFechaLimiteInscripcion().equals(cursoAModificar.getFechaLimiteInscripcion())){

            // La fecha del curso a modificar es anterior a la fecha actual?
            if(cursoAModificar.getFechaLimiteInscripcion().isBefore(LocalDateTime.now().withHour(0).withMinute(0))){
                throw new UpdateCursoFechaLimiteAnteriorException();
            }
        }

        cursoAModificar.modificarDatos(cursoDatosNuevos);

        if(iRepositorioEditarCurso.update(cursoAModificar)){
            return cursoAModificar;
        }else{
            throw new UpdateCursoException();
        }
    }


}
