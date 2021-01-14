package back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class CrudApp {
    public static  void main(String[] args){
        SpringApplication.run(CrudApp.class);
    }
    @Bean
    public CommandLineRunner loadData(PeliculaRepository repository){
        CommandLineRunner commandLineRunner = (args) -> {
            repository.save(new Pelicula("Gladiator", "Pelicula de gladiadores", "Accion", "www.gladiator.es", "155", "2000"));
            repository.save(new Pelicula("Titanic", "Pelicula de barco", "Drama", "www.titanic.es", "170", "1997"));
            repository.save(new Pelicula("Spiderman", "Pelicula de superheroes", "Ficcion", "www.spiderman.es", "140", "2002"));
        };
        return commandLineRunner;
    }
}
