package it.euris.academy.FinalExam.service;

import java.util.List;
import it.euris.academy.FinalExam.data.dto.RoomDto;

public interface RoomService {

  public List<RoomDto> getAll();
  
  public RoomDto get(Long id);
  
  public RoomDto add(RoomDto dto);
  
  public RoomDto update(RoomDto dto);
  
  public Boolean delete(Long id);
  
  public Double calculateRoomAmount();
}
