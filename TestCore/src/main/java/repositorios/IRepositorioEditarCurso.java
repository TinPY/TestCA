package repositorios;

import modelo.Curso;

public interface IRepositorioEditarCurso {
    boolean update(Curso cursoDatosNuevos);
}
