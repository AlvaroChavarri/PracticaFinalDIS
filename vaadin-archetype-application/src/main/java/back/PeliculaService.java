package back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository PeliculaRepository;

    public List<Pelicula> getAllPeliculas() {
        List<Pelicula> Peliculas = new ArrayList<Pelicula>();
        PeliculaRepository.findAll().forEach(Pelicula -> Peliculas.add(Pelicula));
        return Peliculas;
    }

    public Pelicula getPeliculaById(int id) {
        return PeliculaRepository.findById(id).get();
    }

    public void saveOrUpdate(Pelicula mvoie) {
    	PeliculaRepository.save(mvoie);
    }

    public void delete(int id) {
    	PeliculaRepository.deleteById(id);
    }

}