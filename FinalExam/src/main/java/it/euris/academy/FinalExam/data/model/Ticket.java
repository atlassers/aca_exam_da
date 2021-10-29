package it.euris.academy.FinalExam.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ticket")
@Entity
public class Ticket implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "position")
  private String position;
  
  @Column(name = "price")
  private Double price;

  @Override
  public Dto toDto() {
    // TODO Auto-generated method stub
    return null;
  }
}
