package testboundaries.configuracion;

import casosUso.CrearCuentaCasoUso;
import casosUso.CrearCursoCasoUso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorios.IRepositorioConsultarCuentaPorUsuario;
import repositorios.IRepositorioCrearCuenta;
import repositorios.IRepositorioCrearCurso;

@Configuration
public class UseCaseConfig {

    @Autowired
    private IRepositorioCrearCuenta iRepositorioCrearCuenta;

    @Autowired
    private IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    @Autowired
    private IRepositorioCrearCurso iRepositorioCrearCurso;

    @Bean
    public CrearCuentaCasoUso crearCuentaCasoUso() {
        return new CrearCuentaCasoUso(iRepositorioCrearCuenta,iRepositorioConsultarCuentaPorUsuario);
    }

    @Bean
    public CrearCursoCasoUso crearCursoCasoUso(){
        return new CrearCursoCasoUso(iRepositorioCrearCurso);
    }



}
