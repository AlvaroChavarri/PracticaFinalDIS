package back;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TratamientoJson {

    @Autowired
    PeliculaRepository PeliculaRepository;

    public void buscarPeliculas() throws IOException {
        List<Pelicula> Peliculas = new ArrayList<Pelicula>();
        PeliculaRepository.findAll().forEach(Pelicula -> Peliculas.add(Pelicula));
        //Creacion del json con la librera gson
        //Imprimimos con pretty sin que el codigo se encuentre compacto
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        //Guardamos la informacion de las peliculas dentro del fichero peliculas.json
        gson.toJson(Peliculas,new FileWriter("peliculas.json"));

    }

    public List<Pelicula> LecturadeJson() throws FileNotFoundException {
        //Creacion del objeto gson
        Gson gson = new Gson();
        //Realiza la lecutra del fichero peliculas.json
        List<Pelicula> Peliculas = null;
        try (Reader reader = new FileReader("peliculas.json")) {
            //Conversion del fichero json a onjeto java
            Pelicula pelicula = gson.fromJson(reader, Pelicula.class);
            //Añadimos los objeto al array de peliculas
            Peliculas = new ArrayList<>();
            Peliculas = (List<Pelicula>) pelicula;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Peliculas;
    }
}