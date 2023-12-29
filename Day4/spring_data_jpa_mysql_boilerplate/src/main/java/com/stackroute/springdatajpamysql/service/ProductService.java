package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;
import java.util.List;
//Create service interface here
public interface ProductService {
    //Add abstract methods here
    Product getProductById(Long productId);
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    Product updateProduct(Product updatedProduct, Long productId);
    String deleteProduct(Long productId);
    List<Product> getAllProductsHavingPriceLessThan(double price);
}
