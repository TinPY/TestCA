package testboundaries.controladores;

import adaptadores.ConsultarPuntosPorIdCuentaAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class ConsultarPuntosPorIdCuentaControlador {

    private ConsultarPuntosPorIdCuentaAdapter consultarPuntosPorIdCuentaAdapter;

    public ConsultarPuntosPorIdCuentaControlador(ConsultarPuntosPorIdCuentaAdapter consultarPuntosPorIdCuentaAdapter) {
        this.consultarPuntosPorIdCuentaAdapter = consultarPuntosPorIdCuentaAdapter;
    }

    @RequestMapping(value = "cuenta/{idCuenta}/puntos", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarPuntosPorIdCuenta(@PathVariable("idCuenta") Integer idCuenta ) {
        try {

            Integer puntos = this.consultarPuntosPorIdCuentaAdapter.ConsultarPuntosPorIdCuenta(idCuenta);

            if (puntos != null) {
                return ResponseEntity.status(HttpStatus.OK).body(puntos);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
