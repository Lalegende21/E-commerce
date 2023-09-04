package com.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entites.OrderDetails;

public interface OrderdetailRepo extends JpaRepository<OrderDetails, Long> {

}
