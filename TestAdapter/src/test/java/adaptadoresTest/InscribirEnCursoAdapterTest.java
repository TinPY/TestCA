package adaptadoresTest;

import adaptadores.EditarCursoAdapter;
import adaptadores.InscribirEnCursoAdapter;
import dto.CuentaDTO;
import dto.CursoDTO;
import excepciones.*;
import inputs.EditarCursoInput;
import inputs.InscribirEnCursoInput;
import mockito.MockitoExtension;
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
public class InscribirEnCursoAdapterTest {

    @Mock
    private InscribirEnCursoInput inscribirEnCursoInput;

    @Test
    public void InscribirEnCurso_DatosCorrectos_DevuelveTrue() throws InscripcionACursoFechaLimiteVencidaException, InscripcionACursoExistenteException, UpdateCursoException, PassIncorrectaException {

        when(inscribirEnCursoInput.InscribirEnCurso(1,1,"asdasd")).thenReturn(true);

        InscribirEnCursoAdapter inscribirEnCursoAdapter = new InscribirEnCursoAdapter(inscribirEnCursoInput);

        Assertions.assertTrue(inscribirEnCursoAdapter.InscribirEnCurso(1,1,"asdasd"));

    }

}
