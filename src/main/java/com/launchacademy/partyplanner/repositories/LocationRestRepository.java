package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRestRepository extends PagingAndSortingRepository<Location, Integer> {

}
