package ch.traal.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.traal.demo.entity.Location;
import ch.traal.demo.service.LocationService;

@RestController
public class LocationController {

  
  /* member variables */
  private LocationService locationService;
  
  
  /* constructors */
  
  
  /* methods */
  @Autowired
  public void setLocationService(LocationService locationService) {
    this.locationService = locationService;
  }
  
  @GetMapping("/location")
  public ResponseEntity<List<Location>> getAllLocations() {
    List<Location> list = this.locationService.retrieveLocations();
    
    return new ResponseEntity<>(list, HttpStatus.OK);
  }
}
