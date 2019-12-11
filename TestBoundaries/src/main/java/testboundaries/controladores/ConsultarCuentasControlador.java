package testboundaries.controladores;

import adaptadores.ConsultarCuentasAdapter;
import adaptadores.EditarCuentaAdapter;
import dto.CuentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
public class ConsultarCuentasControlador {

    private ConsultarCuentasAdapter consultarCuentasAdapter;

    public ConsultarCuentasControlador(ConsultarCuentasAdapter consultarCuentasAdapter) {
        this.consultarCuentasAdapter = consultarCuentasAdapter;
    }

    @RequestMapping(value = "cuenta", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarCuentas() {
        try {
            List<CuentaDTO> listaResultado = (List<CuentaDTO>) this.consultarCuentasAdapter.ConsultarCuentas();

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
