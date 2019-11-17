package ch.traal.demo.repository;


import org.springframework.data.repository.CrudRepository;

import ch.traal.demo.entity.Location;

public interface LocationRepository extends CrudRepository<Location, Long>{

}
