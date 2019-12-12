package repositorios;

import modelo.Curso;

public interface IRepositorioConsultarCursoPorId {
    Curso findByIdCurso(Integer idCurso);
}
