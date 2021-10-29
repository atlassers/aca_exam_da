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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.FinalExam.data.archetype.Model;
import it.euris.academy.FinalExam.data.dto.RoomDto;
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
  @JoinTable(name = "room_viewer", joinColumns = @JoinColumn(name = "room_id"),
      inverseJoinColumns = @JoinColumn(name = "viewer_id"))
  private List<Viewer> viewers = new ArrayList<Viewer>();
  
  @OneToOne
  @JoinColumn(name = "film_id")
  private Film filmId;
  
  @ManyToOne
  @JsonIgnore
  private Cinema cinema;

  @Override
  public RoomDto toDto() {
    return RoomDto.builder()
        .id(id != null ? id.toString() : null)
        .filmId(filmId.getId().toString())
        .build();
  }
}
