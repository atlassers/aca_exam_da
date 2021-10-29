package it.euris.academy.FinalExam.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.archetype.Model;
import it.euris.academy.FinalExam.data.dto.CinemaDto;
import it.euris.academy.FinalExam.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cinema")
@Entity
public class Cinema implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @OneToMany
  @JoinTable(name = "cinema_room", inverseJoinColumns = @JoinColumn(name = "room_id"))
  private List<Room> rooms = new ArrayList<Room>();
  
  @Column(name = "total_money")
  private Double totalMoney;

  @Override
  public CinemaDto toDto() {
    return CinemaDto.builder()
        .id(id != null ? id.toString() : null)
        .totalMoney(totalMoney.toString())
        .build();
  }
}
