package com.productsrest.Controller;




import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productsrest.Models.Product;

@RestController
@RequestMapping("/template")
public class Mycontroller {
	
	 static final String  base_url = "http://localhost:8081/products";
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getproducts")
	   public String getProductList() {
	     HttpHeaders headers = new HttpHeaders();
	     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     HttpEntity<String> entity = new HttpEntity<>(headers);
	      return restTemplate.exchange(base_url+"/products/getproduct", HttpMethod.GET, entity, String.class).getBody();
	   }
	
	@PostMapping("/saveproducts")
	   public String createProducts(@RequestBody Product product) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	      return restTemplate.exchange(
	    		  base_url+ "/saveproduct", HttpMethod.POST, entity, String.class).getBody();
	   }
	
	@PutMapping("/updateproducts/{id}")
	   public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	      return restTemplate.exchange(
	    		  base_url+"/updateproduct/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
	
	@DeleteMapping("/deleteproducts/{id}")
	   public String deleteProduct(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(headers);
	      
	      return restTemplate.exchange(
	    		  base_url+ "/deleteproduct/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }

}
