package com.stackroute.springdatajpamysql.repository;


import com.stackroute.springdatajpamysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Create ProductRepo interface extending JpaRepository
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product WHERE price < ?1",nativeQuery = true)
    List<Product> findProductsLessThanPrice(double price);
}
