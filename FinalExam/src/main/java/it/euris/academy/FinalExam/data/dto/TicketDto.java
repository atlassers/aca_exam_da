package it.euris.academy.FinalExam.data.dto;

import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.model.Ticket;
import it.euris.academy.FinalExam.utils.UT;

public class TicketDto implements Dto {

  private String id;
  private String position;
  private String price;
  
  @Override
  public Ticket toModel() {
    return Ticket.builder()
        .id(UT.toLong(id))
        .position(position)
        .price(UT.toDouble(price))
        .build();
  }

}
