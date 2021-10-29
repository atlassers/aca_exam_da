package it.euris.academy.FinalExam.data.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.model.Cinema;
import it.euris.academy.FinalExam.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaDto implements Dto {

  private String id;
  private String totalMoney;
  //@JsonIgnore
  private List<RoomDto> rooms;
  
  @Override
  public Cinema toModel() {
    return Cinema.builder()
        .id(UT.toLong(id))
        .totalMoney(UT.toDouble(totalMoney))
        .build();
  }

}
