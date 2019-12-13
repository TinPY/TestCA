package casosUso;

import excepciones.InscripcionACursoExistenteException;
import excepciones.InscripcionACursoFechaLimiteVencidaException;
import excepciones.PassIncorrectaException;
import excepciones.UpdateCursoException;
import inputs.InscribirEnCursoInput;
import modelo.Cuenta;
import modelo.Curso;
import repositorios.IRepositorioConsultarCuentaPorId;
import repositorios.IRepositorioConsultarCursoPorId;
import repositorios.IRepositorioConsultarInscripcionesPorIdCuenta;
import repositorios.IRepositorioEditarCurso;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class InscribirEnCursoCasoUso implements InscribirEnCursoInput {

    //private IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;
    //private IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;
    private IRepositorioConsultarInscripcionesPorIdCuenta iRepositorioConsultarInscripcionesPorIdCuenta;
    private IRepositorioEditarCurso iRepositorioEditarCurso;

    public InscribirEnCursoCasoUso(
            IRepositorioConsultarInscripcionesPorIdCuenta iRepositorioConsultarInscripcionesPorIdCuenta,
            IRepositorioEditarCurso iRepositorioEditarCurso) {
        //this.iRepositorioConsultarCursoPorId = iRepositorioConsultarCursoPorId;
        //this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
        this.iRepositorioConsultarInscripcionesPorIdCuenta = iRepositorioConsultarInscripcionesPorIdCuenta;
        this.iRepositorioEditarCurso = iRepositorioEditarCurso;
    }

    @Override
    public boolean InscribirEnCurso(Curso curso, Cuenta cuenta, String pass) throws InscripcionACursoExistenteException, InscripcionACursoFechaLimiteVencidaException, PassIncorrectaException, UpdateCursoException {

        //Curso cursoRecuperado = this.iRepositorioConsultarCursoPorId.findByIdCurso(curso.getIdCurso());
        //Cuenta cuentaRecuperado = this.iRepositorioConsultarCuentaPorId.findByIdCuenta(cuenta.getIdCuenta());

        // Pass no corresponde
        if(!cuenta.getPass().equals(pass)){
            throw new PassIncorrectaException();
        }

        // Curso fecha limite vencida
        if(curso.getFechaLimiteInscripcion().isBefore(LocalDateTime.now().withHour(0).withMinute(0))){
            throw new InscripcionACursoFechaLimiteVencidaException();
        }

        // Curso ya inscripto
        Collection<Curso> cursosInscriptos = iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(cuenta.getIdCuenta());

        // Recorremos las inscripciones
        for(Curso cursoInscripto : cursosInscriptos){

            // Si el curso al que queremos inscribir esta dentro de la lista de cursos de nuestra cuenta
            if(curso.getIdCurso().intValue() == cursoInscripto.getIdCurso()){
                throw new InscripcionACursoExistenteException();
            }
        }

        // inscribir al curso
        curso.inscribirCuenta(cuenta);

        // actualizar
        if(iRepositorioEditarCurso.update(curso)){
            return true;
        }else{
            throw new UpdateCursoException();
        }

    }
}
