package hadesboundaries.RestIT;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import testboundaries.TestBoundariesApplication;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCuentaAntes.sql"),
        //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCuentaDespues.sql")
})
public class EditarCuentaRestIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

    @Test
    public void EditarCuenta_DatosCompletos_Ok200() throws Exception {

        JSONObject cuentaDatosNuevos = new JSONObject();
        cuentaDatosNuevos.put("idCuenta", 1);
        cuentaDatosNuevos.put("usuario", "martinpy");
        cuentaDatosNuevos.put("fechaCreacion", LocalDateTime.of(2019, 12, 10,14,0,0));
        cuentaDatosNuevos.put("nombre", "Martin Paez Yañez");
        cuentaDatosNuevos.put("pass", "qweqwe");

        System.out.println(cuentaDatosNuevos);

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(put("/cuenta")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(cuentaDatosNuevos.toString()))
                .andExpect(status().isOk()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


//        TEST POSTMAN
//        {
//            "idCuenta":1,
//            "usuario":"martinpy",
//            "fechaCreacion":"2019-12-10T12:00",
//            "nombre":"Martin Paez Yañez",
//            "pass":"qweqwe"
//
//        }

    }

}
