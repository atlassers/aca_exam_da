package it.euris.academy.FinalExam.data.dto;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.model.Film;
import it.euris.academy.FinalExam.data.model.Room;
import it.euris.academy.FinalExam.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto implements Dto {

  private String id;
  private String filmId;
  @JsonIgnore
  private ArrayList<ViewerDto> viewers;
  
  @Override
  public Room toModel() {
       return Room.builder()
           .id(UT.toLong(id))
           .filmId(Film.builder().id(UT.toLong(filmId)).build())
           .build();
  }

}
