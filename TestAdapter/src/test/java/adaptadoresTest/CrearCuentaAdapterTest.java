package adaptadoresTest;

import adaptadores.CrearCuentaAdapter;
import dto.CuentaDTO;
import excepciones.CuentaExisteException;
import inputs.CrearCuentaInput;
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
public class CrearCuentaAdapterTest {

    @Mock
    public CrearCuentaInput crearCuentaInput;

    @Test
    public void CrearCuenta_DatosCorrectos_CrearCorrectamente() throws CuentaExisteException {

        CuentaDTO cuentaDTO = new CuentaDTO(null,"martinpy", LocalDateTime.now(),"Tincho","asdasd");
        when(crearCuentaInput.CrearCuenta(any(Cuenta.class))).thenReturn(true);

        CrearCuentaAdapter crearCuentaAdapter = new CrearCuentaAdapter(crearCuentaInput);
        Assertions.assertTrue(crearCuentaAdapter.CrearCuenta(cuentaDTO));

    }

    @Test
    public void CrearCuenta_DatosIncompletos_DevuelveNull() throws CuentaExisteException {

        CuentaDTO cuentaDTO = new CuentaDTO(null,"", LocalDateTime.now(),"","");
        when(crearCuentaInput.CrearCuenta(any(Cuenta.class))).thenReturn(true);

        CrearCuentaAdapter crearCuentaAdapter = new CrearCuentaAdapter(crearCuentaInput);
        Assertions.assertFalse(crearCuentaAdapter.CrearCuenta(cuentaDTO));

    }

}
