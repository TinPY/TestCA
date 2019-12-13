package adaptadoresTest;

import adaptadores.ConsultarPuntosPorIdCuentaAdapter;
import inputs.ConsultarPuntosPorIdCuentaInput;
import mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPuntosPorIdCuentaAdapterTest {

    @Mock
    private ConsultarPuntosPorIdCuentaInput consultarPuntosPorIdCuentaInput;

    @Test
    public void ConsultarCursos_ExistenCursos_DevuelveCursos(){

        when(consultarPuntosPorIdCuentaInput.ConsultarPuntosPorIdCuenta(1)).thenReturn(165);

        ConsultarPuntosPorIdCuentaAdapter consultarPuntosPorIdCuentaAdapter = new ConsultarPuntosPorIdCuentaAdapter(consultarPuntosPorIdCuentaInput);

        Assertions.assertEquals(165,consultarPuntosPorIdCuentaAdapter.ConsultarPuntosPorIdCuenta(1).intValue());

    }

}
