package casosUso;

import excepciones.CuentaExisteException;
import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import mockito.MockitoExtension;
import modelo.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarCuentaPorUsuario;
import repositorios.IRepositorioCrearCuenta;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCuentaCasoUsoTest {

    @Mock
    IRepositorioCrearCuenta iRepositorioCrearCuenta;

    @Mock
    IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    @Test
    public void CrearCuenta_CuentaNoExiste_CreaCorrectamente() throws CuentaIncompletaException, CuentaExisteException, CuentaFechaCreacionPosteriorHoyException {

        Cuenta cuentaNueva = Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Tincho","asdasd");
        when(iRepositorioCrearCuenta.persist(cuentaNueva)).thenReturn(true);
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("martinpy")).thenReturn(null);

        CrearCuentaCasoUso crearCuentaCasoUso = new CrearCuentaCasoUso(iRepositorioCrearCuenta,iRepositorioConsultarCuentaPorUsuario);
        Assertions.assertTrue(crearCuentaCasoUso.CrearCuenta(cuentaNueva));

    }

    @Test
    public void CrearCuenta_CuentaExiste_NoSeCrea() throws CuentaIncompletaException, CuentaExisteException, CuentaFechaCreacionPosteriorHoyException {
        Cuenta cuentaNueva = Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Tincho","asdasd");
        when(iRepositorioCrearCuenta.persist(cuentaNueva)).thenReturn(false);
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("martinpy")).thenReturn(null);

        CrearCuentaCasoUso crearCuentaCasoUso = new CrearCuentaCasoUso(iRepositorioCrearCuenta,iRepositorioConsultarCuentaPorUsuario);
        Assertions.assertFalse(crearCuentaCasoUso.CrearCuenta(cuentaNueva));
    }

}
