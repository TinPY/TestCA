package testboundaries.controladores;

import adaptadores.ConsultarCursosAdapter;
import dto.CursoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ConsultarCursosControlador {

    private ConsultarCursosAdapter consultarCursosAdapter;

    public ConsultarCursosControlador(ConsultarCursosAdapter consultarCursosAdapter) {
        this.consultarCursosAdapter = consultarCursosAdapter;
    }

    @RequestMapping(value = "curso", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarCursos() {
        try {
            List<CursoDTO> listaResultado = (List<CursoDTO>) this.consultarCursosAdapter.ConsultarCursos();

            if (listaResultado != null && !listaResultado.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(listaResultado);
            }else{
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ArrayList<>());
            }
        } catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
