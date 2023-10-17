/*package com.zensar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	

	@Bean
	public Docket productapi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().
				apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any()).build();
		
	}

	 private ApiInfo apiInfo() {

		   @SuppressWarnings("deprecation")

		   ApiInfo apiInfo = new ApiInfo(

		   "Item REST API",
		 
		   "All Item related information",
		 
		   "API",
		 
		   "Terms of services",
		 
		   "priya@gmail.com",
		 
		   "License of API",
		 
		   "API License URL");

		   return apiInfo;

		   

		    }
}

*/
