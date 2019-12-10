package repositorios;

import modelo.Curso;

public interface IRepositorioCrearCurso {

    boolean persist(Curso curso);
}
