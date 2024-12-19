package com.psj.csvspringbootdemo.csvSpringBootDemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String Description;
    private Integer price;
    private String ManufacturBy;
    private Date ManufacturingDate;
    private Date ExpiryDate;

    public Integer getId() {
        return id;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getManufacturBy() {
        return ManufacturBy;
    }

    public void setManufacturBy(String manufacturBy) {
        ManufacturBy = manufacturBy;
    }

    public Date getManufacturingDate() {
        return ManufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        ManufacturingDate = manufacturingDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }

    public Product(String productName, String description, Integer price, String manufacturBy, Date manufacturingDate, Date expiryDate) {

        this.productName = productName;
        Description = description;
        this.price = price;
        ManufacturBy = manufacturBy;
        ManufacturingDate = manufacturingDate;
        ExpiryDate = expiryDate;
    }
}
