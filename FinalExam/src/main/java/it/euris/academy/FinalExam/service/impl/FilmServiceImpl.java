package it.euris.academy.FinalExam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.FinalExam.data.dto.FilmDto;
import it.euris.academy.FinalExam.data.model.Film;
import it.euris.academy.FinalExam.exception.IdMustBeNullException;
import it.euris.academy.FinalExam.exception.IdMustNotBeNullException;
import it.euris.academy.FinalExam.repository.FilmRepository;
import it.euris.academy.FinalExam.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

  @Autowired
  FilmRepository filmRepository;
  
  @Override
  public List<FilmDto> getAll() {
    return filmRepository.findAll().stream().map(Film::toDto).collect(Collectors.toList());
  }

  @Override
  public FilmDto get(Long id) {
    Optional<Film> film = filmRepository.findById(id);
    
    if(film.isPresent()) {
      return film.get().toDto();
    }
    return null;
  }

  @Override
  public FilmDto add(FilmDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return filmRepository.save(dto.toModel()).toDto();
  }

  @Override
  public FilmDto update(FilmDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return filmRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    filmRepository.deleteById(id);
    
    return filmRepository.findById(id).isEmpty();
  }
}
