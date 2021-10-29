package it.euris.academy.FinalExam.data.dto;

import it.euris.academy.FinalExam.data.archetype.Dto;
import it.euris.academy.FinalExam.data.model.Film;
import it.euris.academy.FinalExam.utils.UT;

public class FilmDto implements Dto {

  private String id;
  private String title;
  private String author;
  private String producer;
  private String type;
  private String minimumAge;
  private String duration;
  
  @Override
  public Film toModel() {
    return Film.builder()
        .id(UT.toLong(id))
        .title(title)
        .author(author)
        .producer(producer)
        .type(type)
        .minimumAge(UT.toInteger(minimumAge))
        .duration(UT.toInteger(duration))
        .build();
  }
}
