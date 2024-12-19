package com.productsrest;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductsRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsRestTemplateApplication.class, args);
		
		
	}
	
	@Bean
	public RestTemplate getRsRestTemplate() {
		return new RestTemplate();
	}

}
