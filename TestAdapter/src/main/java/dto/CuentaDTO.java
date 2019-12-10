package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CuentaDTO {

    @JsonProperty("idCuenta")
    private Integer idCuenta;

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("fechaCreacion")
    private LocalDateTime fechaCreacion;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("pass")
    private String pass;

    @JsonCreator
    public CuentaDTO(
            @JsonProperty("idCuenta") Integer idCuenta,
            @JsonProperty("usuario") String usuario,
            @JsonProperty("fechaCreacion") LocalDateTime fechaCreacion,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("pass") String pass) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.pass = pass;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
