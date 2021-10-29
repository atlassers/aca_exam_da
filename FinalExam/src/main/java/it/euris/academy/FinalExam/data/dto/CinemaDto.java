package it.euris.academy.FinalExam.data.dto;

import java.util.List;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.model.Cinema;
import it.euris.academy.FinalExam.utils.UT;

public class CinemaDto implements Dto {

  private String id;
  private String totalMoney;
  private List<RoomDto> rooms;
  
  @Override
  public Cinema toModel() {
    return Cinema.builder()
        .id(UT.toLong(id))
        .totalMoney(UT.toDouble(totalMoney))
        .build();
  }

}
