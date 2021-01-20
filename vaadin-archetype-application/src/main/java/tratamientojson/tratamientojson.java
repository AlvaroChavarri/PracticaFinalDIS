package tratamientojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaadinarchetypeapplication.data.entity.Film;
import vaadinarchetypeapplication.data.service.FilmRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class tratamientojson {

    @Autowired
    FilmRepository PeliculaRepository;

    public void CreacionJson() throws IOException {
        //Obtenemos las peliculas de la base de datos
        List<Film> Peliculas = new ArrayList<Film>();
        PeliculaRepository.findAll().forEach(Pelicula -> Peliculas.add(Pelicula));
        //Creacion del json con la librera gson
        //Imprimimos con pretty sin que el codigo se encuentre compacto
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        //Guardamos la informacion de las peliculas dentro del fichero peliculas.json
        gson.toJson(Peliculas,new FileWriter("peliculas.json"));

    }

    public List<Film> LecturadeJson() throws FileNotFoundException {
        //Creacion del objeto gson
        Gson gson = new Gson();
        //Realiza la lecutra del fichero peliculas.json
        List<Film> Peliculas = null;
        try (Reader reader = new FileReader("peliculas.json")) {
            //Conversion del fichero json a onjeto java
            Film pelicula = gson.fromJson(reader, Film.class);
            //Añadimos los objeto al array de peliculas
            Peliculas = new ArrayList<>();
            Peliculas = (List<Film>) pelicula;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Peliculas;
    }
}