package it.euris.academy.FinalExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.FinalExam.data.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
