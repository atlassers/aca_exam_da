package it.euris.academy.FinalExam.service;

import java.util.List;
import it.euris.academy.FinalExam.data.dto.CinemaDto;

public interface CinemaService {

  public List<CinemaDto> getAll();
  
  public CinemaDto get(Long id);
  
  public CinemaDto add(CinemaDto dto);
  
  public CinemaDto update(CinemaDto dto);
  
  public Boolean delete(Long id);
}
