package it.euris.academy.FinalExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.euris.academy.FinalExam.data.model.Viewer;

public interface ViewerRepository extends JpaRepository<Viewer, Long> {

  //@Query(value = "")
  //Integer isAdult();
  
  @Query(value = "SELECT datediff(NOW(), date_birth)/365 AS age "
      + "   FROM final_exam.viewer AS v")
  Integer getAge();
}
