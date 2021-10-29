package it.euris.academy.FinalExam.service;

import java.util.List;
import it.euris.academy.FinalExam.data.dto.TicketDto;

public interface TicketService {

  public List<TicketDto> getAll();
  
  public TicketDto get(Long id);
  
  public TicketDto add(TicketDto dto);
  
  public TicketDto update(TicketDto dto);
  
  public Boolean delete(Long id);
}
