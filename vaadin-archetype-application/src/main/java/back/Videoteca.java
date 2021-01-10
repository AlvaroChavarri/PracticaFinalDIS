package back;

import java.util.ArrayList;

public class Videoteca {

    private String nombre;
    private ArrayList<Pelicula> pelicula;
    private String ubicacion;
    private String fecha;

    public Videoteca(String nombre, ArrayList<Pelicula> pelicula, String ubicacion,
                     String fecha) {
        this.nombre = nombre;
        this.pelicula = pelicula;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Pelicula> getPelicula() {
        return pelicula;
    }

    public void setPelicula( ArrayList<Pelicula> pelicula) {
        this.pelicula = pelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "Nombre=" + nombre + ", Pelicula=" + pelicula + ", Ubicacion="
                + ubicacion + ", Fecha=" + fecha;
    }
}
