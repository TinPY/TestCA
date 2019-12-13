package adaptadoresTest;

import adaptadores.ConsultarCursoCantidadMaximaInscriptosAdapter;
import adaptadores.ConsultarPromedioInscriptosAdapter;
import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import excepciones.CursoIncompletoException;
import inputs.ConsultarCursoCantidadMaximaInscriptosInput;
import inputs.ConsultarPromedioInscriptosInput;
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
public class ConsultarCursoCantidadMaximaInscriptosAdapterTest {


    @Mock
    private ConsultarCursoCantidadMaximaInscriptosInput consultarCursoCantidadMaximaInscriptosInput;

    @Test
    public void ConsultarCursoCantidadMaximaInscriptos_HayCursos_DevuelveCurso() throws CursoIncompletoException {

        Curso cursoMaximaCantidadInscriptos = Curso.instancia(1,"Algoritmos",factoryInscriptosAlgorimos(),LocalDateTime.now().plusDays(15),175);

        when(consultarCursoCantidadMaximaInscriptosInput.ConsultarCursoCantidadMaximaInscriptos()).thenReturn(cursoMaximaCantidadInscriptos);

        ConsultarCursoCantidadMaximaInscriptosAdapter consultarCursoCantidadMaximaInscriptosAdapter = new ConsultarCursoCantidadMaximaInscriptosAdapter(consultarCursoCantidadMaximaInscriptosInput);

        Assertions.assertEquals(3,consultarCursoCantidadMaximaInscriptosAdapter.ConsultarCursoCantidadMaximaInscriptos().getInscriptos().size());

    }

    List<Cuenta> factoryInscriptosAlgorimos(){

        List<Cuenta> cuentas = new ArrayList<>();
        try {
            cuentas.add(Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin Paez Yañez","qweqwe"));
            cuentas.add(Cuenta.instancia(2,"felipem", LocalDateTime.now(),"Felipe Medina","zxcxzc"));
            cuentas.add(Cuenta.instancia(3,"lalol", LocalDateTime.now(),"Lalo Landa","asdasd"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }

        return cuentas;

    }

}
