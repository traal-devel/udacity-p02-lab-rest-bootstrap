package ch.traal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.traal.demo.entity.Location;
import ch.traal.demo.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

  
  /* member variables */
  @Autowired
  LocationRepository locationRepository;

  
  /* methods */
  public List<Location> retrieveLocations() {
      return (List<Location>) locationRepository.findAll();
  }
}
