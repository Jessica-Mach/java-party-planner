package com.launchacademy.partyplanner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parties")
@NoArgsConstructor
@Getter
@Setter
public class Party {
  @Id
  @SequenceGenerator(name="party_generator", sequenceName="parties_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="party_generator")
  @Column(name="id", nullable=false, unique=true, columnDefinition = "serial")
  private Integer id;

  @NotBlank(message = "Name cannot be blank")
  @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
  @Column(name = "name")
  private String name;

  @NotBlank(message = "Name cannot be blank")
  @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "location_id", nullable = false)
  private Location location;

  public void setLocation(Location location) {
    this.location = location;
  }
}
