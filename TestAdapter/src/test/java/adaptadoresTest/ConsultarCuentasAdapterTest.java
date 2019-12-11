package adaptadoresTest;

import adaptadores.ConsultarCuentasAdapter;
import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import inputs.ConsultarCuentasInput;
import mockito.MockitoExtension;
import modelo.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCuentasAdapterTest {


    @Mock
    private ConsultarCuentasInput consultarCuentasInput;

    @Test
    public void ConsultarCuentas_ExistenCuentas_DevuelveCuentas(){

        when(consultarCuentasInput.ConsultarCuentas()).thenReturn(fabricaListaCuentas());

        ConsultarCuentasAdapter consultarCuentasAdapter = new ConsultarCuentasAdapter(consultarCuentasInput);

        Assertions.assertEquals(2,consultarCuentasAdapter.ConsultarCuentas().size());

    }

    private List<Cuenta> fabricaListaCuentas(){

        List<Cuenta> cuentas = new ArrayList<>();
        try {
            cuentas.add(Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin Paez Yañez","zxczxc"));
            cuentas.add(Cuenta.instancia(1,"felipem", LocalDateTime.now(),"Felipe Medina","poipoi"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }

        return cuentas;
    }
}
