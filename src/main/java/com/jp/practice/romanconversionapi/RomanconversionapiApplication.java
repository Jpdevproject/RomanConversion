package com.jp.practice.romanconversionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class RomanconversionapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(RomanconversionapiApplication.class, args);
	}
	@Bean
	public Docket romanApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jp.practice"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Roman Transformation Api",
				"Sample Api for Roman Transformation",
				"1.0","Free to use",new springfox.documentation.service.Contact("Jyotiprakash","http://jppractice","jyotipbe1988@gmail.com"),
				"Api License","http://jppractice", Collections.emptyList());
	}

}
