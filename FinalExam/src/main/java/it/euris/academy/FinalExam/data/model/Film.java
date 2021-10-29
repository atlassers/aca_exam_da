package it.euris.academy.FinalExam.data.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.archetype.Model;
import it.euris.academy.FinalExam.data.dto.FilmDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "film")
@Entity
public class Film implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "title")
  private String title;
  
  @Column(name = "author")
  private String author;
  
  @Column(name = "producer")
  private String producer;
  
  @Column(name = "type")
  private String type;
  
  @Column(name = "minimum_age")
  private Integer minimumAge;
  
  @Column(name = "duration")
  private Integer duration;
  
  @Override
  public FilmDto toDto() {
    return FilmDto.builder()
        .id(id != null ? id.toString() : null)
        .title(title)
        .author(author)
        .producer(producer)
        .type(type)
        .minimumAge(minimumAge.toString())
        .duration(duration.toString())
        .build();
  }

}
