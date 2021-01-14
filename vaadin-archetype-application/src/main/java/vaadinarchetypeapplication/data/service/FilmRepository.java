package vaadinarchetypeapplication.data.service;

import org.springframework.data.jpa.repository.JpaRepository;
import vaadinarchetypeapplication.data.entity.Film;

import java.time.LocalDate;
public interface FilmRepository extends JpaRepository<Film, Integer> {
}
