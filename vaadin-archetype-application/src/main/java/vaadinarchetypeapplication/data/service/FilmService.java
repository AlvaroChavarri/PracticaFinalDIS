package vaadinarchetypeapplication.data.service;

import vaadinarchetypeapplication.data.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.time.LocalDate;

@Service
public class FilmService extends CrudService<Person, Integer> {

    private PersonRepository repository;

    public FilmService(@Autowired PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    protected PersonRepository getRepository() {
        return repository;
    }

}
