package it.euris.academy.FinalExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.FinalExam.data.model.Viewer;

public interface ViewerRepository extends JpaRepository<Viewer, Long> {

}
