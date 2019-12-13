package testboundaries.controladores;

import adaptadores.ConsultarCursoCantidadMinimaInscriptosAdapter;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import modelo.Curso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;


@RequestMapping("/")
@RestController
public class ConsultarCursoCantidadMinimaInscriptosControlador {

    private ConsultarCursoCantidadMinimaInscriptosAdapter consultarCursoCantidadMinimaInscriptosAdapter;

    public ConsultarCursoCantidadMinimaInscriptosControlador(ConsultarCursoCantidadMinimaInscriptosAdapter consultarCursoCantidadMinimaInscriptosAdapter) {
        this.consultarCursoCantidadMinimaInscriptosAdapter = consultarCursoCantidadMinimaInscriptosAdapter;
    }

    @RequestMapping(value = "curso/mininscriptos", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarPromedioInscriptos() {
        try {

            Curso resultado = this.consultarCursoCantidadMinimaInscriptosAdapter.ConsultarCursoCantidadMinimaInscriptos();

//            JSONObject curso = new JSONObject();
//            curso.put("titulo", resultado.getTitulo());
//            curso.put("inscriptos", resultado.getInscriptos().size());

            JsonObject curso = new JsonObject();
            curso.add("titulo",new JsonPrimitive(resultado.getTitulo()) );
            curso.add("cantidad_inscriptos", new JsonPrimitive(resultado.getInscriptos().size()));

            if (resultado != null ) {
                //return ResponseEntity.status(HttpStatus.OK).body(resultado);
                return ResponseEntity.status(HttpStatus.OK).body(curso.toString());
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
