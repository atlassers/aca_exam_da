package it.euris.academy.FinalExam.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import it.euris.academy.FinalExam.data.dto.ViewerDto;
import it.euris.academy.FinalExam.data.model.Viewer;
import it.euris.academy.FinalExam.repository.ViewerRepository;
import it.euris.academy.FinalExam.service.ViewerService;
import it.euris.academy.FinalExam.utils.TestSupport;

@SpringBootTest
public class ViewerControllerTest {
  
  @Autowired
  private ViewerService viewerService;
  
  @MockBean
  private ViewerRepository viewerRepository;
  
  @Test
  void getAll() {
    List<Viewer> mockedViewers = TestSupport.createViewerList();
    
    when(viewerRepository.findAll()).thenReturn(mockedViewers);
    
    List<ViewerDto> viewerList = viewerService.getAll();
    
    assertEquals(mockedViewers.size(), viewerList.size());
  }
  
  @Test
  void get() {
    Long id = 12L;
    Viewer viewertoReturn = TestSupport.createViewer(id);
    
    when(viewerRepository.findById(id)).thenReturn(Optional.of(viewertoReturn));
    
    ViewerDto viewerDto = viewerService.get(id);
    
    assertEquals(viewertoReturn.toDto(), viewerDto);
  }
  
  @Test
  void add() {
    Viewer viewerToAdd = TestSupport.createViewer(null);
    Viewer viewerToReturn = TestSupport.createViewer(1L);
    
    when(viewerRepository.save(any())).thenReturn(viewerToReturn.toDto());
    
    ViewerDto viewerDto = viewerService.add(viewerToAdd.toDto());
    
    assertEquals(viewerToReturn.toDto(), viewerDto);
  }

}
