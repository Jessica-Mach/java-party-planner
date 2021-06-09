package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locations")
public class LocationController {

  private LocationService locationService;

  @Autowired
  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @GetMapping
  public String getLocationsList(Model model) {
    model.addAttribute("locations", locationService.findAll());
    return "locations/index";
  }
}
