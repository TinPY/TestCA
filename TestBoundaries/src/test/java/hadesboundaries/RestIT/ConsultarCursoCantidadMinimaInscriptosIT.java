package hadesboundaries.RestIT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import testboundaries.TestBoundariesApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
@AutoConfigureMockMvc
public class ConsultarCursoCantidadMinimaInscriptosIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCursoCantidadMinimaInscriptosAntes.sql")
    public void ConsultarCursoCantidadMinimaInscriptos_EncuentraMaximo_Ok200ConCurso() throws Exception {

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(get("/curso/mininscriptos")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(content().string("{\"titulo\":\"Biologia II\",\"cantidad_inscriptos\":3}")).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());
    }
}
