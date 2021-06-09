package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LocationSeeder implements CommandLineRunner {
  private LocationService locationService;

  @Autowired
  public LocationSeeder(LocationService locationService) {
    this.locationService = locationService;
  }

  @Override
  public void run(String... args) throws Exception {
    if(locationService.findAll().size() == 0) {
      Location location1 = new Location();
      location1.setName("The Old Spaghetti Factory");
      location1.setCity("Lynwood");
      location1.setState("WA");
      location1.setRentalPrice(500.00);
      locationService.save(location1);

      Location location2 = new Location();
      location2.setName("Cedar Park");
      location2.setCity("Bothell");
      location2.setState("WA");
      locationService.save(location2);
    }
  }
}
