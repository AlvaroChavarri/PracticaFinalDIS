package vaadinarchetypeapplication.data.service;

import vaadinarchetypeapplication.data.entity.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

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
