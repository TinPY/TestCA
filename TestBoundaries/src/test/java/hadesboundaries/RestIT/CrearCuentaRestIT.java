package hadesboundaries.RestIT;

import com.google.gson.Gson;
import dto.CuentaDTO;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.SerializationConfig;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import testboundaries.TestBoundariesApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/CrearCuentaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/CrearCuentaDespues.sql")
})
public class CrearCuentaRestIT {

    @Autowired
    private MockMvc mvc;

    private String url = "http://localhost:8080";

    @Test
    public void CrearCuenta_DatosCompletos_CreaDictado() throws Exception {

//        CuentaDTO cuentaDTO = new CuentaDTO(1,"martinpy",LocalDateTime.now(),"Tincho","asdasd")
//
//        Gson gson = new Gson();
//        String cuentaStr = gson.toJson(cuentaDTO);
//
//        System.out.println(cuentaStr);

        JSONObject cuenta = new JSONObject();
        cuenta.put("idCuenta", null);
        cuenta.put("usuario", "martinpy");
        cuenta.put("fechaCreacion", LocalDateTime.of(2019, 12, 10,12,0,0));
        cuenta.put("nombre", "Tincho");
        cuenta.put("pass", "qweqwe");

        System.out.println(cuenta);

//        HttpPost post = new HttpPost(url + "/cuenta");
//        StringEntity se = new StringEntity(cuenta.toString());
//        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//        post.setEntity(se);
//        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
//        HttpUriRequest request = post;
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//
//        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));

        // Se realiza el request
        MvcResult resultadoTest = this.mvc.perform(post("/cuenta")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(cuenta.toString()))
                .andExpect(status().isOk()).andReturn();

        System.out.println(resultadoTest.getResponse().getContentAsString());


    }

}
