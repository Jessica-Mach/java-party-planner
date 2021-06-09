package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartiesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartiesService {
  private PartiesRepository partiesRepository;

  @Autowired
  public PartiesService(PartiesRepository partiesRepository) {
    this.partiesRepository = partiesRepository;
  }

  public List<Party> findAll() {
    return (List<Party>) partiesRepository.findAll();
  }

  public void save(Party party) {
    partiesRepository.save(party);
  }
}
