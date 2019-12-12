package hadesboundaries.RestIT;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
@AutoConfigureMockMvc
@SqlGroup({
        //@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCursosAntes.sql"),
        //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCursosDespues.sql")
})
public class ConsultarCursosIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCursosAntes.sql")
    public void ConsultarCursos_HayCursos_Ok200ConCursos() throws Exception {
        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(get("/curso")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCursosVACIOAntes.sql")
    public void ConsultarCursos_SinCursos_NoContent204ArrayVacio() throws Exception {
        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(get("/curso")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());
    }

}
