package com.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entites.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long> {

}
