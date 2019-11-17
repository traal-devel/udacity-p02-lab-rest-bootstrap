package ch.traal.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.traal.demo.entity.Dog;
import ch.traal.demo.service.DogService;

@RestController
public class DogController {

  
  /* member variables */
  @Autowired
  private DogService dogService;
  
  
  /* constructors */
  public DogController() {
    super();
  }
  
  
  /* methods */
  /**
   * A list of Dog breeds.
   * 
   * @return
   */
  @GetMapping("/dog/list")
  public ResponseEntity<List<Dog>> getListOfDogs() {
    List<Dog> retList = this.dogService.retreiveDogs();
    
    return ResponseEntity.ok(retList);
  }
  
  /**
   * A list of Dog breeds.
   * 
   * @return
   */
  @GetMapping("/dog/breeds")
  public ResponseEntity<List<String>> getListOfBreeds() {
    List<String> retList = this.dogService.retrieveDogBreeds();
    
    return ResponseEntity.ok(retList);
  }
  
  /**
   * A list of Dog breeds by Id.
   * 
   * @return
   */
  @GetMapping("/dog/{id}/breed")
  public ResponseEntity<String> getListOfDogBreedsById(
      @PathVariable("id") Long id
  ) {
    String breed = this.dogService.retrieveDogBreedById(id);
    return ResponseEntity.ok(breed);
  }
  
  @GetMapping("/dog/{id}/breedv2")
  public ResponseEntity<String> getListOfDogBreedsByIdV2(
      @PathVariable("id") Long id
  ) {
    String breed = this.dogService.retrieveDogBreedByIdV2(id);
    return ResponseEntity.ok(breed);
  }
  
  /**
   * A list of Dog names.
   * @return
   */
  @GetMapping("/dog/names")
  public ResponseEntity<List<String>> getListOfDogNames() {
    List<String> retList = this.dogService.retrieveDogNames();
    
    return ResponseEntity.ok(retList);
  }

}
