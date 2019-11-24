package ch.traal.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UdacityP02Ex03RestBootstrapApplication {

  public static void main(String[] args) {
    SpringApplication.run(UdacityP02Ex03RestBootstrapApplication.class, args);
  }

//  @Bean
//  public ObjectMapper jacksonObjectMapper() {
////    return new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//    return objectMapper;
//  }

//  @Bean
//  public RestTemplate restTemplate() {
//    RestTemplate restTemplate = new RestTemplate();
//    List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//    MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
////    jsonMessageConverter.setObjectMapper(jacksonObjectMapper());
//    messageConverters.add(jsonMessageConverter);
//    restTemplate.setMessageConverters(messageConverters);
//
//    return restTemplate;
//  }
  
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
