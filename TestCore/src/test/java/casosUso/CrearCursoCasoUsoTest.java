package casosUso;

import excepciones.CuentaExisteException;
import excepciones.CuentaIncompletaException;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import mockito.MockitoExtension;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioCrearCurso;

import java.time.LocalDateTime;
import java.util.HashSet;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoCasoUsoTest {

    @Mock
    IRepositorioCrearCurso iRepositorioCrearCurso;

    @Test
    public void CrearCurso_DatosCompletos_CreaCorrectamente() throws CursoFechaLimiteAnteriorException, CursoIncompletoException {

        Curso cursoNuevo = Curso.instancia(1,"Algoritmos",new HashSet<>(),LocalDateTime.now().plusDays(10),90);
        when(iRepositorioCrearCurso.persist(cursoNuevo)).thenReturn(true);

        CrearCursoCasoUso crearCursoCasoUso = new CrearCursoCasoUso(iRepositorioCrearCurso);
        Assertions.assertTrue(crearCursoCasoUso.CrearCurso(cursoNuevo));
    }

}
