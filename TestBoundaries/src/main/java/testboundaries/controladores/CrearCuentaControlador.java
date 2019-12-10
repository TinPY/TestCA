package testboundaries.controladores;

import adaptadores.CrearCuentaAdapter;
import dto.CuentaDTO;
import excepciones.CuentaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class CrearCuentaControlador {

    private CrearCuentaAdapter crearCuentaAdapter;

    public CrearCuentaControlador(CrearCuentaAdapter crearCuentaAdapter) {
        this.crearCuentaAdapter = crearCuentaAdapter;
    }

    //@PostMapping(value = "cuenta",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "cuenta", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearCuenta(@RequestBody CuentaDTO cuentaDTO) {

        try {
            boolean resultado = this.crearCuentaAdapter.CrearCuenta(cuentaDTO);
            if (resultado) {
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (CuentaExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        } catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
