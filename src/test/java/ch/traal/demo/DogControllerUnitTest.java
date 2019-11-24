package ch.traal.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ch.traal.demo.service.DogService;
import ch.traal.demo.web.DogController;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

  
  /* constants */
  private Logger logger = LogManager.getLogger(DogControllerUnitTest.class);
  
  /* member variables */
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DogService dogService;
  
  
  /* constructors */
  public DogControllerUnitTest() {
    super();
  }

  
  /* methods */
  @Test
  @WithMockUser(
      username = "admin", 
      password = "password", 
      roles = "USER"
  )
  public void getDogList() throws Exception {
    this.mockMvc.perform(get("/dog/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]")); // expect a list / array
    
    verify(dogService, times(1)).retreiveDogs();
  }

}
