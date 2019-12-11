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
        //@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCuentasAntes.sql"),
        //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCuentasDespues.sql")
})
public class ConsultarCuentasIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCuentasAntes.sql")
    public void ConsultarCuentas_HayCuentas_Ok200ConCuentas() throws Exception {
        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(get("/cuenta")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCuentasVACIOAntes.sql")
    public void ConsultarCuentas_SinCuentas_NoContent204ArrayVacio() throws Exception {
        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(get("/cuenta")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNoContent()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());
    }

}
