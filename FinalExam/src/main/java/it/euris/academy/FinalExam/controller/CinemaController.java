package it.euris.academy.FinalExam.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.FinalExam.data.dto.CinemaDto;
import it.euris.academy.FinalExam.service.CinemaService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

  @Autowired
  CinemaService cinemaService;
  
  @GetMapping("/v1")
  public List<CinemaDto> getAll() {
    return cinemaService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public CinemaDto getById(@PathVariable("id") Long id) {
    return cinemaService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return cinemaService.delete(id);
  }
  
  @PostMapping("/v1")
  public CinemaDto insert(@RequestBody CinemaDto dto) {
    return cinemaService.add(dto);
  }
  
  @PutMapping("/v1")
  public CinemaDto update(@RequestBody CinemaDto dto) {
    return cinemaService.update(dto);
  }
  
  @PatchMapping("/v1")
  public CinemaDto patch(@RequestBody CinemaDto dto) {
    return cinemaService.update(dto);
  }
}
