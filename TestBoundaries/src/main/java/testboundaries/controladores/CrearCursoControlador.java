package testboundaries.controladores;

import adaptadores.CrearCursoAdapter;
import dto.CursoDTO;
import excepciones.CursoFechaLimiteAnteriorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearCursoControlador {

    private CrearCursoAdapter crearCursoAdapter;

    public CrearCursoControlador(CrearCursoAdapter crearCursoAdapter) {
        this.crearCursoAdapter = crearCursoAdapter;
    }

    @RequestMapping(value = "curso", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearCurso(@RequestBody CursoDTO CursoDTO) {

        try {
            boolean resultado = this.crearCursoAdapter.CrearCurso(CursoDTO);
            if (resultado) {
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (CursoFechaLimiteAnteriorException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
