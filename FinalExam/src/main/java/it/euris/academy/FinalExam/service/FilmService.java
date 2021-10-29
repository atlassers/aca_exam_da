package it.euris.academy.FinalExam.service;

import java.util.List;
import it.euris.academy.FinalExam.data.dto.FilmDto;

public interface FilmService {
  
  public List<FilmDto> getAll();
  
  public FilmDto get(Long id);
  
  public FilmDto add(FilmDto dto);
  
  public FilmDto update(FilmDto dto);
  
  public Boolean delete(Long id);
}
