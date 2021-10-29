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
import it.euris.academy.FinalExam.data.dto.RoomDto;
import it.euris.academy.FinalExam.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

  @Autowired
  RoomService roomService;
  
  @GetMapping("/v1")
  public List<RoomDto> getAll() {
    return roomService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public RoomDto getById(@PathVariable("id") Long id) {
    return roomService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return roomService.delete(id);
  }
  
  @PostMapping("/v1")
  public RoomDto insert(@RequestBody RoomDto dto) {
    return roomService.add(dto);
  }
  
  @PutMapping("/v1")
  public RoomDto update(@RequestBody RoomDto dto) {
    return roomService.update(dto);
  }
  
  @PatchMapping("/v1")
  public RoomDto patch(@RequestBody RoomDto dto) {
    return roomService.update(dto);
  }
  
  @GetMapping("/v1/room_amount")
  public Double getRoomAmount() {
    return roomService.calculateRoomAmount();
  }
}
