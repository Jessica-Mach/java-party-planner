package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
