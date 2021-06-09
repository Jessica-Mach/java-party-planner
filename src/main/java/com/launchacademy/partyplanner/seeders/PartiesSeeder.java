package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.LocationService;
import com.launchacademy.partyplanner.services.PartiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartiesSeeder {
  private PartiesService partiesService;
  private LocationService locationService;

  @Autowired
  public PartiesSeeder(PartiesService partiesService, LocationService locationService) {
    this.partiesService = partiesService;
    this.locationService = locationService;
  }

  public void seed() {
    if(partiesService.findAll().size() == 0) {
      Location spaghettiFactory = locationService.findByName("The Old Spaghetti Factory");
      Party alumReunion = new Party();
      alumReunion.setName("Alumni Reunion");
      alumReunion.setDescription("Check in with past Launch teammates, instructors, and alum");
      alumReunion.setLocation(spaghettiFactory);
      partiesService.save(alumReunion);

      Party happyHour = new Party();
      happyHour.setName("Happy Hour");
      happyHour.setDescription("Stop by for drinks and conversation after a long day of coding");
      happyHour.setLocation(spaghettiFactory);
      partiesService.save(happyHour);

      Location cedarPark = locationService.findByName("Cedar Park");
      Party familyPicnic = new Party();
      familyPicnic.setName("Family Picnic");
      familyPicnic.setDescription("Food! Lawn Games! Bring the fam!");
      familyPicnic.setLocation(cedarPark);
      partiesService.save(familyPicnic);
    }

  }
}
