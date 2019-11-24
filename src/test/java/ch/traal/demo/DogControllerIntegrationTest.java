package ch.traal.demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import ch.traal.demo.entity.Dog;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

  
  /* constants */
  private static final Logger logger = LogManager.getLogger(DogControllerUnitTest.class);
  
  /* member variables */
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  
  /* constructors */
  public DogControllerIntegrationTest() {
    super();
  }

  
  /* methods */
  /**
   * Attention WithMockUser does not work with TestRestTemplate. 
   * We have to use withBasicAuth, see below... 
   */
  @Test
//  @WithMockUser(
//      username = "admin", 
//      password = "password", 
//      roles = "USER"
//  )
  public void getDogListTest() {
    ResponseEntity<Dog[]> response = 
        this.restTemplate
              .withBasicAuth("admin", "password")
              .getForEntity("http://localhost:" + port + "/dog/list", Dog[].class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    assertNotNull(response.getBody());
    assertTrue(response.getBody().length > 0);
    
    for (Dog dog : response.getBody()) {
      logger.info(" +++ " + dog.getName());
    }
  }
  
  @Test
  public void getDogByIdTest() {
    ResponseEntity<Dog> response = 
        this.restTemplate
              .withBasicAuth("admin", "password")
              .getForEntity("http://localhost:" + port + "/dog/1", Dog.class);
    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    assertNotNull(response.getBody());
    assertEquals(1L, response.getBody().getId());
    
    Dog dog = response.getBody();
    logger.info(" ++++ " + dog.getName());
  }

}
