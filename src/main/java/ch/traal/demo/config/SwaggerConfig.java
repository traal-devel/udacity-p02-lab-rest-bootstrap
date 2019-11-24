package ch.traal.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  
  
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
//                .useDefaultResponseMessages(false);
//              use the last configuration if you want to define own error messages, eg.:
//    @ApiResponses(value = {
//        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
//        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
//        @ApiResponse(code=500, message = "The server is down. Please make sure that the Location microservice is running.")
//    })
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
                "Dog API",
                "This API returns a list of dogs (fci - breeds - definitions)",
                "1.0",
                "http://www.udacity.com/tos",
                new Contact("Traal Devel", "www.udacity.com", "devel@traal.ch"),
                "License of API", "http://www.udacity.com/license", Collections.emptyList());
  }
}
