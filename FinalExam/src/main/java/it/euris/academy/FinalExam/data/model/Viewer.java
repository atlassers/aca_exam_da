package it.euris.academy.FinalExam.data.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.archetype.Model;
import it.euris.academy.FinalExam.data.dto.ViewerDto;
import it.euris.academy.FinalExam.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "viewer")
@Entity
public class Viewer implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "surname")
  private String surname;
  
  @Column(name = "date_birth")
  private Instant dateBirth;
  
  @OneToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticketId;
  
  @ManyToOne
  @JsonIgnore
  private Room roomId;
  
  @Override
  public ViewerDto toDto() {
    return ViewerDto.builder()
        .id(id != null ? id.toString() : null)
        .name(name)
        .surname(surname)
        .dateBirth(UT.fromInstant(dateBirth))
        .ticketId(ticketId.getId().toString())
        .build();
  }

}
