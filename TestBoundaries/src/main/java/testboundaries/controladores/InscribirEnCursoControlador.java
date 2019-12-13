package testboundaries.controladores;

import adaptadores.InscribirEnCursoAdapter;
import excepciones.InscripcionACursoExistenteException;
import excepciones.InscripcionACursoFechaLimiteVencidaException;
import excepciones.PassIncorrectaException;
import excepciones.UpdateCursoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class InscribirEnCursoControlador {

    private InscribirEnCursoAdapter inscribirEnCursoAdapter;

    public InscribirEnCursoControlador(InscribirEnCursoAdapter inscribirEnCursoAdapter) {
        this.inscribirEnCursoAdapter = inscribirEnCursoAdapter;
    }

    @RequestMapping(value = "inscripcion", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> editarCuenta(@RequestParam Integer idCurso, @RequestParam Integer idCuenta, @RequestParam String pass) {

        // Si falta alguno de los parametros, devolver BAD REQUEST
        if(idCurso == null || idCuenta == null || pass.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // INSCRIBIR EN CURSO
        try {
            boolean resultado = this.inscribirEnCursoAdapter.InscribirEnCurso(idCurso, idCuenta, pass);
            if (resultado) {
                return ResponseEntity.status(HttpStatus.OK).body(true);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (InscripcionACursoExistenteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(false);
        } catch (PassIncorrectaException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
        } catch (InscripcionACursoFechaLimiteVencidaException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(false);
        } catch (UpdateCursoException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
