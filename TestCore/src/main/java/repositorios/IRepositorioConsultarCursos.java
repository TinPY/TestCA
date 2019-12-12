package repositorios;

import modelo.Curso;

import java.util.Collection;

public interface IRepositorioConsultarCursos {

    Collection<Curso> findAll();
}
