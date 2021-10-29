package it.euris.academy.FinalExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.FinalExam.data.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long>{

}
