package adaptadoresTest;

import adaptadores.ConsultarCursosAdapter;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import inputs.ConsultarCursosInput;
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
public class ConsultarCursosAdapterTest {


    @Mock
    private ConsultarCursosInput consultarCursosInput;

    @Test
    public void ConsultarCursos_ExistenCursos_DevuelveCursos(){

        when(consultarCursosInput.ConsultarCursos()).thenReturn(factoryCursos());

        ConsultarCursosAdapter consultarCursosAdapter = new ConsultarCursosAdapter(consultarCursosInput);

        Assertions.assertEquals(3,consultarCursosAdapter.ConsultarCursos().size());

    }

    List<Curso> factoryCursos(){

        List<Curso> cursos = new ArrayList<>();
        try {
            cursos.add(Curso.instancia(1,"Quimica",new ArrayList<>(),LocalDateTime.now().plusDays(10),120));
            cursos.add(Curso.instancia(2,"Sommelier 1",new ArrayList<>(),LocalDateTime.now().plusDays(3),95));
            cursos.add(Curso.instancia(3,"Electronica Digital",new ArrayList<>(),LocalDateTime.now().plusDays(7),105));
        } catch (CursoIncompletoException e) {
            e.printStackTrace();
        } catch (CursoFechaLimiteAnteriorException e) {
            e.printStackTrace();
        }

        return cursos;

    }
}
