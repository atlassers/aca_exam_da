package it.euris.academy.FinalExam.utils;

import java.time.Instant;
import java.util.List;
import it.euris.academy.FinalExam.data.model.Film;
import it.euris.academy.FinalExam.data.model.Room;
import it.euris.academy.FinalExam.data.model.Viewer;

public class TestSupport {

  public static Viewer createViewer(Long id) {
    return Viewer.builder().id(id).dateBirth(Instant.parse("1990-12-12T00:00:00Z")).name("Gigi").surname("Gigio").build();
  }
  
  public static List<Viewer> createViewerList() {
    return List.of(createViewer(1L), createViewer(2L));
  }
  
  public static Room createRoom(Long id) {
    return Room.builder().id(id).filmId(Film.builder().id(1L).build()).build();
  }
  
  public static List<Room> createRoomList() {
    return List.of(createRoom(1L), createRoom(2L));
  }
}
