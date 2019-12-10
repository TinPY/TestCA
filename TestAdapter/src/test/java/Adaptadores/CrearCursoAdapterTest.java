package Adaptadores;

import adaptadores.CrearCursoAdapter;
import dto.CursoDTO;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import inputs.CrearCursoInput;
import mockito.MockitoExtension;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoAdapterTest {

    @Mock
    public CrearCursoInput crearCursoInput;

    @Test
    public void CrearCurso_DatosCorrectos_CrearCorrectamente() throws CursoFechaLimiteAnteriorException, CursoIncompletoException {

        CursoDTO CursoDTO = new CursoDTO(1,"Informatica Aplicada", new HashSet<>(),LocalDateTime.now().plusDays(5),0);
        when(crearCursoInput.CrearCurso(any(Curso.class))).thenReturn(true);

        CrearCursoAdapter crearCursoAdapter = new CrearCursoAdapter(crearCursoInput);
        Assertions.assertTrue(crearCursoAdapter.CrearCurso(CursoDTO));

    }

}
