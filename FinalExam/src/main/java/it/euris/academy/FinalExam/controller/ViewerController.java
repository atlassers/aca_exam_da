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
import it.euris.academy.FinalExam.data.dto.ViewerDto;
import it.euris.academy.FinalExam.service.ViewerService;

@RestController
@RequestMapping("/viewers")
public class ViewerController {

  @Autowired
  ViewerService viewerService;
  
  @GetMapping("/v1")
  public List<ViewerDto> getAll() {
    return viewerService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public ViewerDto getById(@PathVariable("id") Long id) {
    return viewerService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return viewerService.delete(id);
  }
  
  @PostMapping("/v1")
  public ViewerDto insert(@RequestBody ViewerDto dto) {
    return viewerService.add(dto);
  }
  
  @PutMapping("/v1")
  public ViewerDto update(@RequestBody ViewerDto dto) {
    return viewerService.update(dto);
  }
  
  @PatchMapping("/v1")
  public ViewerDto patch(@RequestBody ViewerDto dto) {
    return viewerService.update(dto);
  }
  
  @GetMapping("/v1/age")
  public Integer getAge() {
    return viewerService.getAge();
  }
}
