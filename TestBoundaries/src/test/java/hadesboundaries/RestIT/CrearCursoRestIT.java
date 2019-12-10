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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/CrearCursoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/CrearCursoDespues.sql")
})
public class CrearCursoRestIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

    @Test
    public void CrearCurso_DatosCompletos_Ok200() throws Exception {

        JSONObject curso = new JSONObject();
        curso.put("idCurso", null);
        curso.put("titulo", "Realidad Aumentada");
        curso.put("inscriptos", factoryInscriptos());
        curso.put("fechaLimiteInscripcion", LocalDateTime.of(2019, 12, 15,12,0,0));
        curso.put("puntos", 95);

        System.out.println(curso);

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(post("/curso")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(curso.toString()))
                .andExpect(status().isOk()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


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
