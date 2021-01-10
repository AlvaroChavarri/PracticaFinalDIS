package back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {

    @Autowired
    PeliculaService PeliculaService;

    @GetMapping("/Peliculas")
    private List<Pelicula> getAllPeliculas() {
        return PeliculaService.getAllPeliculas();
    }

    @GetMapping("/Peliculas/{id}")
    private Pelicula getPelicula(@PathVariable("id") int id) {
        return PeliculaService.getPeliculaById(id);
    }

    @DeleteMapping("/Peliculas/{id}")
    private void deletePelicula(@PathVariable("id") int id) {
        PeliculaService.delete(id);
    }

    @PostMapping("/Peliculas")
    private int savePelicula(@RequestBody Pelicula Pelicula) {
        PeliculaService.saveOrUpdate(Pelicula);
        return Pelicula.getId();
    }
}