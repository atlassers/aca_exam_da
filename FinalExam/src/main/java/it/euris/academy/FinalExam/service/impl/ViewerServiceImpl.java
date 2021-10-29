package it.euris.academy.FinalExam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.FinalExam.data.dto.ViewerDto;
import it.euris.academy.FinalExam.data.model.Viewer;
import it.euris.academy.FinalExam.exception.IdMustBeNullException;
import it.euris.academy.FinalExam.exception.IdMustNotBeNullException;
import it.euris.academy.FinalExam.repository.ViewerRepository;
import it.euris.academy.FinalExam.service.ViewerService;

@Service
public class ViewerServiceImpl implements ViewerService {

  @Autowired
  ViewerRepository viewerRepository;
  
  @Override
  public List<ViewerDto> getAll() {
    return viewerRepository.findAll().stream().map(Viewer::toDto).collect(Collectors.toList());
  }

  @Override
  public ViewerDto get(Long id) {
    Optional<Viewer> viewer = viewerRepository.findById(id);
    
    if(viewer.isPresent()) {
      return viewer.get().toDto();
    }
    return null;
  }

  @Override
  public ViewerDto add(ViewerDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return viewerRepository.save(dto.toModel()).toDto();
  }

  @Override
  public ViewerDto update(ViewerDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return viewerRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    viewerRepository.deleteById(id);
    
    return viewerRepository.findById(id).isEmpty();
  }

  @Override
  public Integer getAge() {
    return viewerRepository.getAge();
  }

  @Override
  public Boolean isAdult() {
    int age = viewerRepository.getAge();
    if(age < 18) {
      return false;
    }
    else return true;
  }

}
