package com.spring.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.productservice.repository.entitiy.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
    Product getByProductIdAndDeletedFalse(Long productId);

    List<Product> getAllByDeletedFalse();
}
