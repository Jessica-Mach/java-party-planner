package com.launchacademy.partyplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@Getter
@Setter
public class Location {
  @Id
  @SequenceGenerator(name="location_generator", sequenceName="locations_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="location_generator")
  @Column(name="id", nullable=false, unique=true, columnDefinition = "serial")
  private Integer id;

  @NotBlank(message = "Name cannot be blank")
  @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
  @Column(name = "name")
  private String name;

  @NotBlank(message = "City cannot be blank")
  @Size(min = 3, max = 255, message = "City must be between 3 and 255 characters")
  @Column(name = "city")
  private String city;

  @NotBlank(message = "State cannot be blank")
  @Size(min = 2, max = 2, message = "State must be a valid two letter state abbreviation")
  @Column(name = "state")
  private String state;

  @Column(name = "rental_price", columnDefinition = "numeric")
  private double rentalPrice;

  @OneToMany(mappedBy = "location")
  @JsonIgnoreProperties("location")
  private List<Party> parties = new ArrayList<>();

  public String displayPrice() {
    return rentalPrice > 0 ? "$" + String.format("%.2f", rentalPrice) : "free";
  }
}
