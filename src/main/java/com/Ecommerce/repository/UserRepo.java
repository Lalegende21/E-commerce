package com.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entites.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByPhone(int phone);

}
