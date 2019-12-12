package casosUso;

import excepciones.UpdateCursoException;
import inputs.EditarCursoInput;
import modelo.Curso;
import repositorios.IRepositorioConsultarCursoPorId;
import repositorios.IRepositorioEditarCurso;

public class EditarCursoCasoUso implements EditarCursoInput {

    private IRepositorioEditarCurso iRepositorioEditarCurso;
    private IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    public EditarCursoCasoUso(IRepositorioEditarCurso iRepositorioEditarCurso, IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId) {
        this.iRepositorioEditarCurso = iRepositorioEditarCurso;
        this.iRepositorioConsultarCursoPorId = iRepositorioConsultarCursoPorId;
    }


    @Override
    public Curso EditarCurso(Curso cursoDatosNuevos) throws UpdateCursoException {
        Curso cursoAModificar = iRepositorioConsultarCursoPorId.findByIdCurso(cursoDatosNuevos.getIdCurso());
        cursoAModificar.modificarDatos(cursoDatosNuevos);

        if(iRepositorioEditarCurso.update(cursoAModificar)){
            return cursoAModificar;
        }else{
            throw new UpdateCursoException();
        }
    }


}
