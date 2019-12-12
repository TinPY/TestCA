package hadesboundaries.RestIT;

import org.json.JSONArray;
import org.json.JSONException;
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
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCursoAntesConDatos.sql"),
        //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCursoDespues.sql")
})
public class EditarCursoRestIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

    @Test
    public void EditarCurso_DatosCompletos_Ok200() throws Exception {

        JSONObject cursoDatosNuevos = new JSONObject();
        cursoDatosNuevos.put("idCurso", 1);
        cursoDatosNuevos.put("titulo", "Programacion III");
        //cursoDatosNuevos.put("inscriptos", factoryInscriptos());
        cursoDatosNuevos.put("inscriptos", new JSONArray());
        cursoDatosNuevos.put("fechaLimiteInscripcion", LocalDateTime.of(2019, 12, 31,00,0,0));
        cursoDatosNuevos.put("puntos", 90);

        System.out.println(cursoDatosNuevos);

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(put("/curso")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(cursoDatosNuevos.toString()))
                .andExpect(status().isOk()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


//        TEST POSTMAN
//        {
//            "idCurso":1,
//            "fechaLimiteInscripcion":"2019-12-15T12:00",
//            "titulo":"Inteligencia Artificial",
//            "puntos":140,
//            "inscriptos":[]
//        }

//        INSCRIPTOS CON GENTE
//            "inscriptos":[
//                    {"pass":"qweqwe","fechaCreacion":"2019-12-10T12:00","usuario":"martinpy","nombre":"Tincho"}
//            ]

    }

    private JSONArray factoryInscriptos() throws JSONException {

        JSONObject cuenta = new JSONObject();
        cuenta.put("idCuenta", null);
        cuenta.put("usuario", "martinpy");
        cuenta.put("fechaCreacion", LocalDateTime.of(2019, 12, 10,12,0,0));
        cuenta.put("nombre", "Tincho");
        cuenta.put("pass", "qweqwe");

        JSONArray inscriptos = new JSONArray();
        inscriptos.put(cuenta);

        return inscriptos;
    }

}
