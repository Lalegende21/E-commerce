package com.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entites.ProductsCategories;

public interface ProductsCategoriesRepo extends JpaRepository<ProductsCategories, Long> {

	ProductsCategories findByName(String name);

}
