package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.LocationService;
import com.launchacademy.partyplanner.services.PartiesService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parties")
public class PartiesController {
  private LocationService locationService;
  private PartiesService partiesService;

  @Autowired
  public PartiesController(LocationService locationService, PartiesService partiesService) {
    this.locationService = locationService;
    this.partiesService = partiesService;
  }

  @GetMapping
  public String getPartiesList() {
    // ADD GET PARTIES
    return "parties/index";
  }

  @GetMapping("/new")
  public String getNewPartyForm(@ModelAttribute Party party, Model model) {
    model.addAttribute("locations", locationService.findAll());
    return "parties/new";
  }

  @PostMapping
  public String createNewParty(@ModelAttribute @Valid Party party, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "parties/new";
    } else {
      partiesService.save(party);
      return "redirect:/parties/" + party.getId();
    }
  }
}
