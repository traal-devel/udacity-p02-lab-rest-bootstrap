package ch.traal.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@SpringBootApplication
public class UdacityP02Ex03RestBootstrapApplication {

  public static void main(String[] args) {
    SpringApplication.run(UdacityP02Ex03RestBootstrapApplication.class, args);
  }

//  @Bean
//  public ObjectMapper jacksonObjectMapper() {
//    return new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
//    jsonMessageConverter.setObjectMapper(jacksonObjectMapper());
    messageConverters.add(jsonMessageConverter);
    restTemplate.setMessageConverters(messageConverters);

    return restTemplate;
  }

}
