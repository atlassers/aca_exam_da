package it.euris.academy.FinalExam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.FinalExam.data.dto.RoomDto;
import it.euris.academy.FinalExam.data.model.Room;
import it.euris.academy.FinalExam.exception.IdMustBeNullException;
import it.euris.academy.FinalExam.exception.IdMustNotBeNullException;
import it.euris.academy.FinalExam.repository.RoomRepository;
import it.euris.academy.FinalExam.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

  @Autowired
  RoomRepository roomRepository;
  
  @Override
  public List<RoomDto> getAll() {
    return roomRepository.findAll().stream().map(Room::toDto).collect(Collectors.toList());
  }

  @Override
  public RoomDto get(Long id) {
    Optional<Room> room = roomRepository.findById(id);
    
    if(room.isPresent()) {
      return room.get().toDto();
    }
    return null;
  }

  @Override
  public RoomDto add(RoomDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return roomRepository.save(dto.toModel()).toDto();
  }

  @Override
  public RoomDto update(RoomDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return roomRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    roomRepository.deleteById(id);
    
    return roomRepository.findById(id).isEmpty();
  }
  
  @Override
  public Double calculateRoomAmount() {
    return roomRepository.calculateRoomAmount();
  }

}
