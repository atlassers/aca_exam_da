package it.euris.academy.FinalExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.euris.academy.FinalExam.data.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

  /*
  @Query(value = "SELECT * FROM final_exam.room AS r "
      + "   JOIN final_exam.room_viewer AS rv ON r.id = rv.room_id "
      + "   JOIN final_exam.viewer AS v ON rv.viewer_id = v.id "
      + "   JOIN final_exam.ticket AS t ON v.ticket_id = t.id", nativeQuery = true)
  Double calculateRoomAmount();
  */
}
