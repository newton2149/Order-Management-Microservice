package com.navneeth.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navneeth.ProductService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
