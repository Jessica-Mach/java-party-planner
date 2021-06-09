package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.repositories.LocationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  private LocationRepository locationRepository;

  @Autowired
  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public List<Location> findAll() {
    return (List<Location>) locationRepository.findAll();
  }

  public void save(Location location) {
    locationRepository.save(location);
  }

  public Optional<Location> findById(Integer id) {
    return locationRepository.findById(id);
  }

  public Location findByName(String name) {
    return locationRepository.findByName(name);
  }
}
