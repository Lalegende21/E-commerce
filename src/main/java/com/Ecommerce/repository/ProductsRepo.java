package com.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entites.Products;

public interface ProductsRepo extends JpaRepository<Products, Long> {

}
