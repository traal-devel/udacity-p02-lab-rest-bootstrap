package ch.traal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.traal.demo.entity.Dog;

public interface DogRepository extends CrudRepository<Dog, Long>{

  
  /* methods */
  @Query(
    value = "SELECT DISTINCT d.breed FROM Dog d",
    nativeQuery = true
  )
  public List<String> findAllBreeds();
  
  @Query(
    value = "SELECT breed FROM Dog d WHERE d.id=:id",
    nativeQuery = true
  )
  public String findBreedById(Long id);
  
  @Query(
    value = "SELECT DISTINCT d.name FROM Dog d",
    nativeQuery = true
  )
  public List<String> findAllNames();
}
