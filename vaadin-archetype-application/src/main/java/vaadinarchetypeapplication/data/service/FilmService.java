package vaadinarchetypeapplication.data.service;

import vaadinarchetypeapplication.data.entity.Film;
import vaadinarchetypeapplication.data.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.time.LocalDate;

@Service
public class FilmService extends CrudService<Film, Integer> {

    private FilmRepository repository;

    public FilmService(@Autowired FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    protected FilmRepository getRepository() {
        return repository;
    }

}
