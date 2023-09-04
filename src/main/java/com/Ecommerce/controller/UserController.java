package com.Ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.entites.User;
import com.Ecommerce.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// La methodde pour inserer les donnees (Create du crud)
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping()
	public void created(@RequestBody User user) {
		this.userService.create(user);
	}

	// La methodde pour lire les utilisateur (Read du crud)
	@GetMapping()
	public List<User> search() {
		return this.userService.search();
	}

	// La methode pour lire les utilisateurs par id
	@GetMapping(path = "{id}")
	public User read(@PathVariable int id) {
		return this.userService.read(id);
	}

	// La methode pour modifier les données des utilisateurs
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@PutMapping(path = "{id}")
	public void update(@PathVariable Long id, @RequestBody User user) {
		this.userService.update(id, user);
	}

	// La methode pour supprimer tous les utilisateurs
	@DeleteMapping()
	public void deleteAll() {
		this.userService.deleteAll();
	}

	// La methode pour supprimer un utilisateur par son identifiant
	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable Long id) {
		this.userService.delete(id);
	}
}
