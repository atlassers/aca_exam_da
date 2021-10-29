package it.euris.academy.FinalExam.data.dto;

import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.model.Ticket;
import it.euris.academy.FinalExam.data.model.Viewer;
import it.euris.academy.FinalExam.utils.UT;

public class ViewerDto implements Dto {

  private String id;
  private String name;
  private String surname;
  private String dateBirth;
  private String ticketId;
  
  @Override
  public Viewer toModel() {
    return Viewer.builder()
        .id(UT.toLong(id))
        .name(name)
        .surname(surname)
        .dateBirth(UT.toInstant(dateBirth))
        .ticketId(Ticket.builder().id(UT.toLong(ticketId)).build())
        .build();
  }

}
