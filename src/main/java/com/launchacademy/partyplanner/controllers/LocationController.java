package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.services.LocationService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

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

  @GetMapping("/{id}")
  public String getLocationShow(@PathVariable Integer id, Model model) {
    Optional<Location> showLocation = locationService.findById(id);

    if(showLocation.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } else {
      model.addAttribute("location", showLocation.get());
    }
    return "locations/show";
  }

  @GetMapping("/new")
  public String getNewLocationForm(@ModelAttribute Location location) {
    return "locations/new";
  }

  @PostMapping
  public String createLocation(@ModelAttribute @Valid Location location, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "locations/new";
    } else {
      locationService.save(location);
      return "redirect:/locations";
    }
  }
}
