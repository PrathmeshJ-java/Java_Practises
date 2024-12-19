package com.psj.csvspringbootdemo.csvSpringBootDemo.Repositories;

import com.psj.csvspringbootdemo.csvSpringBootDemo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
