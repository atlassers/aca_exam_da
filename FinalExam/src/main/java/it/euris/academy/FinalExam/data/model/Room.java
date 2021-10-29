package it.euris.academy.FinalExam.data.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "room")
@Entity
public class Room implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @OneToMany
  @JoinColumn(name = "viewers")
  private List<Viewer> viewers;
  
  @OneToOne
  @JoinColumn(name = "film_id")
  private Film filmId;

  @Override
  public Dto toDto() {
    // TODO Auto-generated method stub
    return null;
  }
}
