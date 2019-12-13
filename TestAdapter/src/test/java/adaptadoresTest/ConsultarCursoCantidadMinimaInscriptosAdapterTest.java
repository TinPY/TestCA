package adaptadoresTest;

import adaptadores.ConsultarCursoCantidadMinimaInscriptosAdapter;
import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import excepciones.CursoIncompletoException;
import inputs.ConsultarCursoCantidadMinimaInscriptosInput;
import mockito.MockitoExtension;
import modelo.Cuenta;
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
public class ConsultarCursoCantidadMinimaInscriptosAdapterTest {


    @Mock
    private ConsultarCursoCantidadMinimaInscriptosInput consultarCursoCantidadMinimaInscriptosInput;

    @Test
    public void ConsultarCursoCantidadMinimaInscriptos_HayCursos_DevuelveCurso() throws CursoIncompletoException {

        Curso cursoMinimaCantidadInscriptos = Curso.instancia(1,"Algoritmos",factoryInscriptosAlgorimos(),LocalDateTime.now().plusDays(3),175);

        when(consultarCursoCantidadMinimaInscriptosInput.ConsultarCursoCantidadMinimaInscriptos()).thenReturn(cursoMinimaCantidadInscriptos);

        ConsultarCursoCantidadMinimaInscriptosAdapter consultarCursoCantidadMinimaInscriptosAdapter = new ConsultarCursoCantidadMinimaInscriptosAdapter(consultarCursoCantidadMinimaInscriptosInput);

        Assertions.assertEquals(2,consultarCursoCantidadMinimaInscriptosAdapter.ConsultarCursoCantidadMinimaInscriptos().getInscriptos().size());

    }

    List<Cuenta> factoryInscriptosAlgorimos(){

        List<Cuenta> cuentas = new ArrayList<>();
        try {
            cuentas.add(Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin Paez Yañez","qweqwe"));
            cuentas.add(Cuenta.instancia(2,"felipem", LocalDateTime.now(),"Felipe Medina","zxcxzc"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }

        return cuentas;

    }

}
