package back;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    private String sinopsis;
    private String genero;
    private String estreno;
    private String duracion;
    private String enlace;
    public Pelicula(String titulo, String sinopsis, String genero, String enlace,String duracion,String estreno){
        this.titulo=titulo;
        this.sinopsis=sinopsis;
        this.genero=genero;
        this.enlace=enlace;
        this.estreno=estreno;
        this.duracion=duracion;
    }

    public Pelicula() {

    }
    public int getId() {
        return id;
    }
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

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String toString() {
        return "Titulo=" + titulo + ", Sinopsis=" + sinopsis + ", Genero=" + genero+",Enlace"+enlace;
    }
}
