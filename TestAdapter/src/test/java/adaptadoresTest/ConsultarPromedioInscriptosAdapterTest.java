package adaptadoresTest;

import adaptadores.ConsultarCursosAdapter;
import adaptadores.ConsultarPromedioInscriptosAdapter;
import excepciones.CursoIncompletoException;
import inputs.ConsultarCursosInput;
import inputs.ConsultarPromedioInscriptosInput;
import mockito.MockitoExtension;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPromedioInscriptosAdapterTest {


    @Mock
    private ConsultarPromedioInscriptosInput consultarPromedioInscriptosInput;

    @Test
    public void ConsultarPromedioInscriptosEnCursos_ExistenInscriptosCursos_DevuelvePromedio(){

        when(consultarPromedioInscriptosInput.ConsultarPromedioInscriptos()).thenReturn(Float.valueOf(25.5f));
        ConsultarPromedioInscriptosAdapter consultarPromedioInscriptosAdapter = new ConsultarPromedioInscriptosAdapter(consultarPromedioInscriptosInput);

        Assertions.assertEquals(Float.valueOf(25.5f),consultarPromedioInscriptosAdapter.ConsultarPromedioInscriptos());

    }

}
