package testboundaries.controladores;

import adaptadores.EditarCursoAdapter;
import dto.CursoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class EditarCursoControlador {

    private EditarCursoAdapter editarCursoAdapter;

    public EditarCursoControlador(EditarCursoAdapter editarCursoAdapter) {
        this.editarCursoAdapter = editarCursoAdapter;
    }

    @RequestMapping(value = "curso", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> editarCurso(@RequestBody CursoDTO CursoDTO) {
        try {
            CursoDTO resultado = this.editarCursoAdapter.EditarCurso(CursoDTO);

            if (resultado != null) {
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }else{
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
