package it.euris.academy.FinalExam.service;

import java.util.List;
import it.euris.academy.FinalExam.data.dto.ViewerDto;

public interface ViewerService {

  public List<ViewerDto> getAll();
  
  public ViewerDto get(Long id);
  
  public ViewerDto add(ViewerDto dto);
  
  public ViewerDto update(ViewerDto dto);
  
  public Boolean delete(Long id);
  
  public Integer getAge();
  
  public Boolean isAdult();
}
