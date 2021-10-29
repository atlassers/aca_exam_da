package it.euris.academy.FinalExam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.FinalExam.data.dto.CinemaDto;
import it.euris.academy.FinalExam.data.model.Cinema;
import it.euris.academy.FinalExam.exception.IdMustBeNullException;
import it.euris.academy.FinalExam.exception.IdMustNotBeNullException;
import it.euris.academy.FinalExam.repository.CinemaRepository;
import it.euris.academy.FinalExam.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

  @Autowired
  CinemaRepository cinemaRepository;
  
  @Override
  public List<CinemaDto> getAll() {
    return cinemaRepository.findAll().stream().map(Cinema::toDto).collect(Collectors.toList());
  }

  @Override
  public CinemaDto get(Long id) {
    Optional<Cinema> cinema = cinemaRepository.findById(id);
    
    if(cinema.isPresent()) {
      return cinema.get().toDto();
    }
    return null;
  }

  @Override
  public CinemaDto add(CinemaDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return cinemaRepository.save(dto.toModel()).toDto();
  }

  @Override
  public CinemaDto update(CinemaDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return cinemaRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    cinemaRepository.deleteById(id);
    
    return cinemaRepository.findById(id).isEmpty();
  }

}
