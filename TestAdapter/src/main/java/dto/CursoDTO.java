package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Collection;

public class CursoDTO {

    @JsonProperty("idCurso")
    public final Integer idCurso;

    @JsonProperty("titulo")
    public final String titulo;

    @JsonProperty("inscriptos")
    public final Collection<CuentaDTO> inscriptos;

    @JsonProperty("fechaLimiteInscripcion")
    public final LocalDateTime fechaLimiteInscripcion;

    @JsonProperty("puntos")
    public final Integer puntos;

    @JsonCreator
    public CursoDTO(
            @JsonProperty("idCurso") Integer idCurso,
            @JsonProperty("titulo") String titulo,
            @JsonProperty("inscriptos") Collection<CuentaDTO> inscriptos,
            @JsonProperty("fechaLimiteInscripcion") LocalDateTime fechaLimiteInscripcion,
            @JsonProperty("puntos") Integer puntos) {
        this.idCurso = idCurso;
        this.titulo = titulo;
        this.inscriptos = inscriptos;
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
        this.puntos = puntos;
    }


}
