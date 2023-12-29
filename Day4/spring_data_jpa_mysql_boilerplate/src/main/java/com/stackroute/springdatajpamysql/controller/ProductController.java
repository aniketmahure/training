package com.stackroute.springdatajpamysql.controller;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    // Add controllers here for CRUD operations on Product entity.
    @Autowired
    ProductService productService;
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product updatedProduct,@PathVariable Long productId) {
        return new ResponseEntity<>(productService.updateProduct(updatedProduct,productId), HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
    }
    @GetMapping("/products/{price}")
    public ResponseEntity<?> getAllProductsHavingPriceLessThan(@PathVariable double price) {
        return new ResponseEntity<>(productService.getAllProductsHavingPriceLessThan(price), HttpStatus.OK);
    }

}
