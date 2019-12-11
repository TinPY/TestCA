package adaptadoresTest;

import adaptadores.CrearCuentaAdapter;
import adaptadores.EditarCuentaAdapter;
import dto.CuentaDTO;
import excepciones.CuentaExisteException;
import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import excepciones.UpdateCuentaException;
import factorys.CuentaFactory;
import inputs.EditarCuentaInput;
import mockito.MockitoExtension;
import modelo.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarCuentaAdapterTest {

    @Mock
    public EditarCuentaInput editarCuentaInput;

    @Test
    public void CrearCuenta_DatosCorrectos_CrearCorrectamente() throws CuentaIncompletaException, UpdateCuentaException, CuentaFechaCreacionPosteriorHoyException {

        CuentaDTO cuentaDTO = new CuentaDTO(1,"martinpy", LocalDateTime.now(),"Martin PY","qweqwe");
        when(editarCuentaInput.EditarCuenta(any(Cuenta.class))).thenReturn(Cuenta.instancia(1,"martinpy",LocalDateTime.now(),"Martin PY","qweqwe"));

        EditarCuentaAdapter editarCuentaAdapter = new EditarCuentaAdapter(editarCuentaInput);
        Assertions.assertEquals("Martin PY",editarCuentaAdapter.EditarCuenta(cuentaDTO).getNombre());

    }

}
