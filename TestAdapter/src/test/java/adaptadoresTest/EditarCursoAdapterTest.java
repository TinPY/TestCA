package adaptadoresTest;

import adaptadores.EditarCuentaAdapter;
import adaptadores.EditarCursoAdapter;
import dto.CuentaDTO;
import dto.CursoDTO;
import excepciones.*;
import inputs.EditarCursoInput;
import mockito.MockitoExtension;
import modelo.Cuenta;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarCursoAdapterTest {

    @Mock
    public EditarCursoInput editarCursoInput;

    @Test
    public void CrearCuenta_DatosCorrectos_CrearCorrectamente() throws CursoFechaLimiteAnteriorException, CursoIncompletoException, UpdateCursoException {

        CursoDTO cursoDTO = new CursoDTO(1,"Base de Datos 2", new ArrayList<>(),LocalDateTime.now().plusDays(5),80);
        when(editarCursoInput.EditarCurso(any(Curso.class))).thenReturn(Curso.instancia(1,"Base de Datos 2", new ArrayList<>(),LocalDateTime.now().plusDays(5),156));

        EditarCursoAdapter editarCursoAdapter = new EditarCursoAdapter(editarCursoInput);
        Assertions.assertEquals(156,editarCursoAdapter.EditarCurso(cursoDTO).puntos.intValue());

    }

}
