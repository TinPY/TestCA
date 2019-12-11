package testboundaries.controladores;

import adaptadores.EditarCuentaAdapter;
import dto.CuentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class EditarCuentaControlador {

    private EditarCuentaAdapter editarCuentaAdapter;

    public EditarCuentaControlador(EditarCuentaAdapter editarCuentaAdapter) {
        this.editarCuentaAdapter = editarCuentaAdapter;
    }

    @RequestMapping(value = "cuenta", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> editarCuenta(@RequestBody CuentaDTO cuentaDTO) {
        try {
            CuentaDTO resultado = this.editarCuentaAdapter.EditarCuenta(cuentaDTO);
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
