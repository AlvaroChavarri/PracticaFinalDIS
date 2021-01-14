package vaadinarchetypeapplication.data.service;

import vaadinarchetypeapplication.data.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}