package testboundaries.data.entidades;

import dto.CuentaDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name ="curso")
@SequenceGenerator(name = "curso_idcurso_seq", initialValue = 1, sequenceName = "curso_idcurso_seq", allocationSize = 1)
public class CursoEntidad {

    @Id
    @Column(name = "idcurso")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_idcurso_seq")
    private Integer idCurso;

    @Column(name = "titulo")
    private String titulo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="inscripciones",
            joinColumns=@JoinColumn(name="idcurso", referencedColumnName="idcurso"),
            inverseJoinColumns=@JoinColumn(name="idcuenta", referencedColumnName="idcuenta"))
    private Collection<CuentaEntidad> inscriptos;

    @Column(name = "fechalimiteinscripcion")
    private LocalDateTime fechaLimiteInscripcion;

    @Column(name = "puntos")
    private Integer puntos;

    public CursoEntidad(){}

    public CursoEntidad(Integer idCurso, String titulo, Collection<CuentaEntidad> inscriptos, LocalDateTime fechaLimiteInscripcion, Integer puntos) {
        this.idCurso = idCurso;
        this.titulo = titulo;
        this.inscriptos = inscriptos;
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
        this.puntos = puntos;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Collection<CuentaEntidad> getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Collection<CuentaEntidad> inscriptos) {
        this.inscriptos = inscriptos;
    }

    public LocalDateTime getFechaLimiteInscripcion() {
        return fechaLimiteInscripcion;
    }

    public void setFechaLimiteInscripcion(LocalDateTime fechaLimiteInscripcion) {
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
