package it.euris.academy.FinalExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.FinalExam.data.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long>{

}
