package com.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entites.ProductImage;

public interface ProductsImageRepo extends JpaRepository<ProductImage, Long> {

	ProductImage findByUrl(String url);

}
