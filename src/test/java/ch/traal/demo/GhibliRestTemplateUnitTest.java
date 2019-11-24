package ch.traal.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import ch.traal.demo.entity.ghibli.Film;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GhibliRestTemplateUnitTest {

  
  /* constants */
  private Logger logger = LogManager.getLogger(GhibliRestTemplateUnitTest.class);
  
  /* member variables */
  @Autowired
  private RestTemplate restTemplate;
  
  /* constructors */
  public GhibliRestTemplateUnitTest() {
    super();
  }

  
  /* methods */
  @Test
  public void testNotNull() {
    assertNotNull(this.restTemplate);
  }

  @Test
  public void testConsumeApi() {
    ResponseEntity<Film[]> response= this.restTemplate.getForEntity(
        "https://ghibliapi.herokuapp.com/films", Film[].class);
    
    assertNotNull(response);
    assertNotNull(response.getBody());
    assertTrue(response.getBody().length > 0);
    
    for (Film film : response.getBody()) {
      logger.info("+++ " + film.getTitle() + ", " + film.getRelease_date());
    }
  }
}
