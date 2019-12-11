package testboundaries.configuracion;

import casosUso.ConsultarCuentasCasoUso;
import casosUso.CrearCuentaCasoUso;
import casosUso.CrearCursoCasoUso;
import casosUso.EditarCuentaCasoUso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorios.*;

@Configuration
public class UseCaseConfig {

    @Autowired
    private IRepositorioCrearCuenta iRepositorioCrearCuenta;

    @Autowired
    private IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    @Autowired
    private IRepositorioCrearCurso iRepositorioCrearCurso;

    @Autowired
    private IRepositorioEditarCuenta iRepositorioEditarCuenta;

    @Autowired
    private IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    @Autowired
    private IRepositorioConsultarCuentas iRepositorioConsultarCuentas;

    @Bean
    public CrearCuentaCasoUso crearCuentaCasoUso() {
        return new CrearCuentaCasoUso(iRepositorioCrearCuenta,iRepositorioConsultarCuentaPorUsuario);
    }

    @Bean
    public CrearCursoCasoUso crearCursoCasoUso(){
        return new CrearCursoCasoUso(iRepositorioCrearCurso);
    }

    @Bean
    public EditarCuentaCasoUso editarCuentaCasoUso() { return new EditarCuentaCasoUso(iRepositorioEditarCuenta,iRepositorioConsultarCuentaPorId);}

    @Bean
    public ConsultarCuentasCasoUso consultarCuentasCasoUso() {return new ConsultarCuentasCasoUso(iRepositorioConsultarCuentas);}

}
