package it.euris.academy.FinalExam.data.dto;

import java.util.List;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.model.Film;
import it.euris.academy.FinalExam.data.model.Room;
import it.euris.academy.FinalExam.utils.UT;

public class RoomDto implements Dto {

  private String id;
  private String filmId;
  private List<ViewerDto> viewers;
  
  @Override
  public Room toModel() {
       return Room.builder()
           .id(UT.toLong(id))
           .filmId(Film.builder().id(UT.toLong(filmId)).build())
           .build();
  }

}
