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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
@AutoConfigureMockMvc
@SqlGroup({
        //@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarPuntosPorIdCuentaAntes.sql"),
        //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarPuntosPorIdCuentaDespues.sql")
})
public class ConsultarPuntosPorIdCuentaIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

//    DATOS
//    insert into cuenta values (1,'2019-12-1 17:19:00.219','Felipe Medina','asdasd','felipem');
//    insert into cuenta values (2,'2019-12-10 14:59:50.859','Tincho','qweqwe','martinpy');
//
//    insert into curso values (1, '2019-12-19 20:00:00.000', 125, 'Algoritmos I');
//    insert into curso values (2, '2019-12-15 17:00:00.000', 75, 'Biologia II');
//
//    insert into inscripciones (idcuenta,idcurso) values (1,1);
//    insert into inscripciones (idcuenta,idcurso) values (1,2);


    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarPuntosPorIdCuentaAntes.sql")
    public void ConsultarPuntosPorIdCuenta_HayInscripciones_Ok200ConPuntos() throws Exception {

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(get("/cuenta/1/puntos")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(content().string("200")).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());
    }

}
