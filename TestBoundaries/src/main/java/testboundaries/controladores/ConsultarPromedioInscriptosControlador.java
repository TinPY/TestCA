package testboundaries.controladores;

import adaptadores.ConsultarCursosAdapter;
import adaptadores.ConsultarPromedioInscriptosAdapter;
import dto.CursoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ConsultarPromedioInscriptosControlador {

    private ConsultarPromedioInscriptosAdapter consultarPromedioInscriptosAdapter;

    public ConsultarPromedioInscriptosControlador(ConsultarPromedioInscriptosAdapter consultarPromedioInscriptosAdapter) {
        this.consultarPromedioInscriptosAdapter = consultarPromedioInscriptosAdapter;
    }

    @RequestMapping(value = "inscripcion/promedio", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarPromedioInscriptos() {
        try {

            Float resultado = this.consultarPromedioInscriptosAdapter.ConsultarPromedioInscriptos();

            if (resultado != null ) {
                return ResponseEntity.status(HttpStatus.OK).body(resultado.floatValue());
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
