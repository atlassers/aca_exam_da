package it.euris.academy.FinalExam.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.FinalExam.data.dto.TicketDto;
import it.euris.academy.FinalExam.repository.TicketRepository;
import it.euris.academy.FinalExam.service.TicketService;
import it.euris.academy.FinalExam.data.model.Ticket;
import it.euris.academy.FinalExam.exception.IdMustBeNullException;
import it.euris.academy.FinalExam.exception.IdMustNotBeNullException;

@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  TicketRepository ticketRepository;
  
  @Override
  public List<TicketDto> getAll() {
    return ticketRepository.findAll().stream().map(Ticket::toDto).collect(Collectors.toList());
  }

  @Override
  public TicketDto get(Long id) {
    Optional<Ticket> ticket = ticketRepository.findById(id);
    
    if(ticket.isPresent()) {
      return ticket.get().toDto();
    }
    return null;
  }

  @Override
  public TicketDto add(TicketDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return ticketRepository.save(dto.toModel()).toDto();
  }

  @Override
  public TicketDto update(TicketDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return ticketRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    ticketRepository.deleteById(id);
    
    return ticketRepository.findById(id).isEmpty();
  }

}
