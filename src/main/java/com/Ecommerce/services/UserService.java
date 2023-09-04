package com.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.entites.User;
import com.Ecommerce.repository.UserRepo;

@Service
public class UserService {

	private UserRepo userRepository;

	public UserService(UserRepo userRepository) {
		this.userRepository = userRepository;
	}

	// La methodde pour inserer les donnees (Create du crud)
	public void create(User user) {
		// La methode pour chercher les utilisateurs par email
		User userEmail = this.userRepository.findByEmail(user.getEmail());

		// La methode pour chercher les utilisateurs par phone
		User userPhone = this.userRepository.findByPhone(user.getPhone());

		if (userEmail == null && userPhone == null) {
			this.userRepository.save(user);
		}
	}

	// La methodde pour lire toutes les donnees (Read du crud)
	public List<User> search() {
		return this.userRepository.findAll();
	}

	// La methode pour lire les utilisateurs par id
	public User read(long id) {

		Optional<User> optionalUser = this.userRepository.findById(id);

		return optionalUser.orElse(null);
	}

	// La methode pour faire la mise à jour des données des utilisateurs
	public void update(Long id, User user) {
		User userUpdate = this.read(id);

		if (userUpdate.getId() == user.getId()) {
			userUpdate.setFirstname(user.getFirstname());
			userUpdate.setLastname(user.getLastname());
			userUpdate.setEmail(user.getEmail());
			userUpdate.setPhone(user.getPhone());
			this.userRepository.save(userUpdate);
		}

	}

	// La methode pour supprimer tous les utilisateurs de la tables
	public void deleteAll() {
		this.userRepository.deleteAll();
	}

	// La methode pour supprimer un utilisateur par son id
	public void delete(Long id) {
		this.userRepository.deleteById(id);
	}

}
