package casosUso;

import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import excepciones.UpdateCuentaException;
import mockito.MockitoExtension;
import modelo.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarCuentaPorId;
import repositorios.IRepositorioEditarCuenta;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarCuentaCasoUsoTest {

    @Mock
    IRepositorioEditarCuenta iRepositorioEditarCuenta;

    @Mock
    IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    @Test
    public void editarCuenta_DatosCorrectos_DevuelveCuentaModificada() throws CuentaFechaCreacionPosteriorHoyException, CuentaIncompletaException, UpdateCuentaException {

        Cuenta cuentaViejaAModificar = Cuenta.instancia(1,"martinpy",LocalDateTime.now(),"Tincho PY","asdasd");
        Cuenta cuentaDatosNuevos = Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin Paez Yañez","qweqwe");

        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(1)).thenReturn(cuentaViejaAModificar);
        when(iRepositorioEditarCuenta.update(cuentaViejaAModificar)).thenReturn(true);

        EditarCuentaCasoUso editarCuentaCasoUso = new EditarCuentaCasoUso(iRepositorioEditarCuenta,iRepositorioConsultarCuentaPorId);

        Cuenta cuenta = editarCuentaCasoUso.EditarCuenta(cuentaDatosNuevos);
        Assertions.assertEquals("qweqwe",cuenta.getPass());
        Assertions.assertEquals("Martin Paez Yañez",cuenta.getNombre());

    }

}
