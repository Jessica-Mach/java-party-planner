package com.launchacademy.partyplanner.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  private LocationSeeder locationSeeder;
  private PartiesSeeder partiesSeeder;

  @Autowired
  public MainSeeder(LocationSeeder locationSeeder, PartiesSeeder partiesSeeder) {
    this.locationSeeder = locationSeeder;
    this.partiesSeeder = partiesSeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    locationSeeder.seed();
    partiesSeeder.seed();
  }
}
