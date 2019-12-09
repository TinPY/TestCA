package testboundaries.configuracion;

import casosUso.CrearCuentaCasoUso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositorios.IRepositorioConsultarCuentaPorUsuario;
import repositorios.IRepositorioCrearCuenta;

@Configuration
public class UseCaseConfig {

    @Autowired
    private IRepositorioCrearCuenta iRepositorioCrearCuenta;

    @Autowired
    private IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    @Bean
    public CrearCuentaCasoUso crearCuentaCasoUso() {
        return new CrearCuentaCasoUso(iRepositorioCrearCuenta,iRepositorioConsultarCuentaPorUsuario);
    }



}
