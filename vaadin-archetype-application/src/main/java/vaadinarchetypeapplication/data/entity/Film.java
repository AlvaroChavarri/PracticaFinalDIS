package vaadinarchetypeapplication.data.entity;

import javax.persistence.Entity;

import vaadinarchetypeapplication.data.AbstractEntity;
import java.time.LocalDate;

@Entity
public class Film extends AbstractEntity {

    private String titulo;
    private String sinopsis;
    private String genero;
    private LocalDate estreno;
    private String duracion;
    private String enlace;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public LocalDate getEstreno() {
        return estreno;
    }
    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

}
