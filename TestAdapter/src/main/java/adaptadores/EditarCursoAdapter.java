package adaptadores;

import dto.CursoDTO;
import excepciones.UpdateCursoException;
import factorys.CursoFactory;
import inputs.EditarCursoInput;
import modelo.Curso;

public class EditarCursoAdapter {

    private EditarCursoInput editarCursoInput;

    public EditarCursoAdapter(EditarCursoInput editarCursoInput) {
        this.editarCursoInput = editarCursoInput;
    }

    public CursoDTO EditarCurso(CursoDTO cursoDTO) throws UpdateCursoException {
        Curso curso = this.editarCursoInput.EditarCurso(CursoFactory.mapeoDTOCore(cursoDTO));
        return CursoFactory.mapeoCoreDTO(curso);
    }
}
