package casosUso;

import excepciones.*;
import mockito.MockitoExtension;
import modelo.Cuenta;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarCuentaPorId;
import repositorios.IRepositorioConsultarCursoPorId;
import repositorios.IRepositorioEditarCuenta;
import repositorios.IRepositorioEditarCurso;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarCursoCasoUsoTest {

    @Mock
    IRepositorioEditarCurso iRepositorioEditarCurso;

    @Mock
    IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    @Test
    public void editarCuenta_DatosCorrectos_DevuelveCuentaModificada() throws CursoFechaLimiteAnteriorException, CursoIncompletoException, UpdateCursoException {

        Curso cursoViejoAModificar = Curso.instancia(1,"Algoritmos I", new ArrayList<Cuenta>(),LocalDateTime.now().plusDays(15),125);
        Curso cursoDatosNuevos = Curso.instancia(1,"Algoritmos I", new ArrayList<Cuenta>(),LocalDateTime.now().plusDays(10),110);

        when(iRepositorioConsultarCursoPorId.findByIdCurso(1)).thenReturn(cursoViejoAModificar);
        when(iRepositorioEditarCurso.update(cursoViejoAModificar)).thenReturn(true);

        EditarCursoCasoUso editarCursoCasoUso = new EditarCursoCasoUso(iRepositorioEditarCurso,iRepositorioConsultarCursoPorId);

        Curso curso = editarCursoCasoUso.EditarCurso(cursoDatosNuevos);

        Assertions.assertEquals(110,curso.getPuntos().intValue());

    }

}
