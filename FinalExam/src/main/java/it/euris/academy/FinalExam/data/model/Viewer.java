package it.euris.academy.FinalExam.data.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.archetype.Model;
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
  
  @Override
  public Dto toDto() {
    // TODO Auto-generated method stub
    return null;
  }

}
