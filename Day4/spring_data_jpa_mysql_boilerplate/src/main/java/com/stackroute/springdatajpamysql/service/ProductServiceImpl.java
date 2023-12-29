package com.stackroute.springdatajpamysql.service;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Implement ProductService here
@Service
public class ProductServiceImpl implements ProductService  {
    @Autowired
    ProductRepo productRepo;
    //Override all the methods here
    @Override
    public Product getProductById(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        if (product.isPresent()){
            return product.get();
        }
        else
            return null;
    }
    @Override
    public List getAllProducts() {
        return productRepo.findAll();
    }
    @Override
    public Product saveProduct(Product product) {
        Optional<Product> existingProduct = productRepo.findById(product.getId());
        if (existingProduct.isPresent()) {
            System.out.println("Id already exist");
        }
        else {
            productRepo.save(product);
        }
        return product;
    }
    @Override
    public Product updateProduct(Product updatedProduct, Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        if (product.isPresent()) {
            Product productUpdate = product.get();
            productUpdate.setName(updatedProduct.getName());
            productUpdate.setPrice(updatedProduct.getPrice());
            return productRepo.save(productUpdate);
        }
        else {
            return null;
        }
    }
    @Override
    public String deleteProduct(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        productRepo.deleteById(productId);
        return "Product Deleted";
    }
    @Override
    public List<Product> getAllProductsHavingPriceLessThan(double price) {
        return productRepo.findProductsLessThanPrice(price);
    }
}
