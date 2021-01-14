package vaadinarchetypeapplication.data.generator;
import com.vaadin.flow.spring.annotation.SpringComponent;

import vaadinarchetypeapplication.data.service.FilmRepository;
import vaadinarchetypeapplication.data.entity.Film;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;
@SpringComponent
public class DataGeneratorFilm {
    @Bean
    public CommandLineRunner loadData(FilmRepository filmRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (filmRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Person entities...");
            ExampleDataGenerator<Film> filmRepositoryGenerator = new ExampleDataGenerator<>(Film.class,
                    LocalDateTime.of(2021, 1, 13, 0, 0, 0));
            filmRepositoryGenerator.setData(Film::setId, DataType.ID);
            filmRepositoryGenerator.setData(Film::setSinopsis, DataType.FIRST_NAME);
            filmRepositoryGenerator.setData(Film::setGenero, DataType.LAST_NAME);
            filmRepositoryGenerator.setData(Film::setDuracion, DataType.EMAIL);
            filmRepositoryGenerator.setData(Film::setEstreno, DataType.PHONE_NUMBER);
            filmRepositoryGenerator.setData(Film::setEnlace, DataType.OCCUPATION);
            filmRepository.saveAll(filmRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}
