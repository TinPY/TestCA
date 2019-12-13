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
        //@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoAntes.sql"),
        //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoDespues.sql")
})
public class InscribirEnCursoRestIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

//      DATOS
//      insert into curso values (1, '2019-12-19 20:00:00.000', 125, 'Algoritmos I');
//      insert into cuenta values (1,'2019-12-10 14:59:50.859','Tincho','asdasd','martinpy');

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoSacarInscripcion.sql")
    })
    public void InscribirEnCurso_ParametrosCompletosCorrectos_Ok200() throws Exception {

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(post("/inscripcion?idCurso=1&idCuenta=1&pass=asdasd"))
                .andExpect(status().isOk()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
                    "classpath:scriptsSQL/InscribirEnCursoAntes.sql"
                    ,"classpath:scriptsSQL/InscribirEnCursoAgregarInscripcion.sql"}),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoSacarInscripcion.sql")
    })
    public void InscribirEnCurso_ParametrosCompletosYaInscripto_InscripcionACursoExistenteException_Conflict409() throws Exception {

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(post("/inscripcion?idCurso=1&idCuenta=1&pass=asdasd"))
                .andExpect(status().isConflict()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoAntes.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoSacarInscripcion.sql")
    })
    public void InscribirEnCurso_ParametrosCompletosPassIncorrecta_Forbidden403() throws Exception {

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(post("/inscripcion?idCurso=1&idCuenta=1&pass=ZXCZXC"))
                .andExpect(status().isForbidden()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
                    "classpath:scriptsSQL/InscribirEnCursoAntes.sql",
                    "classpath:scriptsSQL/InscribirEnCursoModificarFechaLimiteCurso.sql"}),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/InscribirEnCursoModificarFechaLimiteCursoDespues.sql")
    })
    public void InscribirEnCurso_ParametrosCompletosCursoFechaLimiteVencida_PRECONDITION_FAILED412() throws Exception {

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(post("/inscripcion?idCurso=1&idCuenta=1&pass=asdasd"))
                .andExpect(status().isPreconditionFailed()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


    }

}
