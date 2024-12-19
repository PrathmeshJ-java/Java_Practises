package com.products.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.products.Models.Product;
import com.products.Repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProdctController {
	
	
	@Autowired
	ProductRepository productRepository;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<Product> SaveProduct(@RequestBody Product product){
		
		Product Prod1 = this.productRepository.save(product);
		
		if(Prod1 != null) {
			return ResponseEntity.ok(Prod1);
		}
		
		return ResponseEntity.ofNullable(Prod1);
		
	}
	
	
	@GetMapping("/getproduct")
	public ResponseEntity<List<Product>> getProduct(){
		
		List<Product> products = new ArrayList<>();
		
		products = this.productRepository.findAll();
		
		if(products != null) {
			return ResponseEntity.ok(products);
		}
		
		return ResponseEntity.ofNullable(products);
		
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
		Optional<Product> product1 = this.productRepository.findById(id);
		if (product1.isPresent()) {
			
			Product existingProduct = product1.get();
			existingProduct.setProduct_name(product.getProduct_name());
			existingProduct.setPrice(product.getPrice());
			Product product2 =this.productRepository.save(existingProduct);
			return ResponseEntity.ok(product2);
			
			 
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(product);
		
		
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		Optional<Product> product1 = this.productRepository.findById(id);
		if (product1.isPresent()) {
			
			this.productRepository.deleteById(id);
			return ResponseEntity.ok("deleted successfully");
			
			 
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something error.. please try again");
		
		
	}
	

}
