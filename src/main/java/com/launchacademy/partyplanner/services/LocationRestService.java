package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.repositories.LocationRestRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocationRestService {
  private LocationRestRepository locationRestRepository;

  @Autowired
  public LocationRestService(
      LocationRestRepository locationRestRepository) {
    this.locationRestRepository = locationRestRepository;
  }

  public Page<Location> findAll(Pageable pageable) {
    return locationRestRepository.findAll(pageable);
  }

  public Optional<Location> findById(Integer id) {
    return locationRestRepository.findById(id);
  }
}
