package testboundaries.configuracion;

import casosUso.*;
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

    @Autowired
    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    @Autowired
    private IRepositorioEditarCurso iRepositorioEditarCurso;

    @Autowired
    private IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    @Autowired
    private  IRepositorioConsultarInscripcionesPorIdCuenta iRepositorioConsultarInscripcionesPorIdCuenta;

    @Bean
    public CrearCuentaCasoUso crearCuentaCasoUso() { return new CrearCuentaCasoUso(iRepositorioCrearCuenta,iRepositorioConsultarCuentaPorUsuario); }

    @Bean
    public CrearCursoCasoUso crearCursoCasoUso(){
        return new CrearCursoCasoUso(iRepositorioCrearCurso);
    }

    @Bean
    public EditarCuentaCasoUso editarCuentaCasoUso() { return new EditarCuentaCasoUso(iRepositorioEditarCuenta,iRepositorioConsultarCuentaPorId);}

    @Bean
    public ConsultarCuentasCasoUso consultarCuentasCasoUso() {return new ConsultarCuentasCasoUso(iRepositorioConsultarCuentas);}

    @Bean
    public ConsultarCursosCasoUso consultarCursosCasoUso() {return new ConsultarCursosCasoUso(iRepositorioConsultarCursos);}

    @Bean
    public EditarCursoCasoUso editarCursoCasoUso() {return new EditarCursoCasoUso(iRepositorioEditarCurso,iRepositorioConsultarCursoPorId);}

    @Bean
    public InscribirEnCursoCasoUso inscribirEnCursoCasoUso() {
        return new InscribirEnCursoCasoUso(
            iRepositorioConsultarCursoPorId,
            iRepositorioConsultarCuentaPorId,
            iRepositorioConsultarInscripcionesPorIdCuenta,
            iRepositorioEditarCurso);
    }

    @Bean
    public ConsultarPuntosPorIdCuentaCasoUso consultarPuntosPorIdCuentaCasoUso(){
        return new ConsultarPuntosPorIdCuentaCasoUso(iRepositorioConsultarInscripcionesPorIdCuenta);
    }

    @Bean
    public ConsultarPromedioInscriptosCasoUso consultarPromedioInscriptosCasoUso(){
        return new ConsultarPromedioInscriptosCasoUso(iRepositorioConsultarCursos);
    }

    @Bean
    public ConsultarCursoCantidadMaximaInscriptosCasoUso consultarCursoCantidadMaximaInscriptosCasoUso(){
        return new ConsultarCursoCantidadMaximaInscriptosCasoUso(iRepositorioConsultarCursos);
    }

    @Bean
    public ConsultarCursoCantidadMinimaInscriptosCasoUso consultarCursoCantidadMinimaInscriptosCasoUso(){
        return new ConsultarCursoCantidadMinimaInscriptosCasoUso(iRepositorioConsultarCursos);
    }

}
