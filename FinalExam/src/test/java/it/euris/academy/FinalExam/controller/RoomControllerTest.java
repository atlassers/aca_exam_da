package it.euris.academy.FinalExam.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import it.euris.academy.FinalExam.data.dto.RoomDto;
import it.euris.academy.FinalExam.data.model.Room;
import it.euris.academy.FinalExam.repository.RoomRepository;
import it.euris.academy.FinalExam.service.RoomService;
import it.euris.academy.FinalExam.utils.TestSupport;

@SpringBootTest
public class RoomControllerTest {

  @Autowired
  RoomService roomService;
  
  @MockBean
  RoomRepository roomRepository;
  
  @Test
  void getAll() {
    List<Room> mockedRooms = TestSupport.createRoomList();
    
    when(roomRepository.findAll()).thenReturn(mockedRooms);
    
    List<RoomDto> rooms = roomService.getAll();
    
    assertEquals(mockedRooms, rooms);
    
    for(int i = 0; i < mockedRooms.size(); i++) {
      assertEquals(mockedRooms.get(i).toDto(), rooms.get(i));
    }
  }
  
  @Test
  void get() {
    Long id = 1L;
    Room mockedRoom = TestSupport.createRoom(id);
    
    when(roomRepository.findById(id)).thenReturn(Optional.of(mockedRoom));
    
    RoomDto roomDto = roomService.get(id);
    
    assertEquals(mockedRoom.toDto(), roomDto);
  }
}
