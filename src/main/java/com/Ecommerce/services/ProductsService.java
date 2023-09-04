package com.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.entites.Products;
import com.Ecommerce.repository.ProductsRepo;

@Service
public class ProductsService {

	private ProductsRepo productsRepo;

	public ProductsService(ProductsRepo productsRepo) {
		this.productsRepo = productsRepo;
	}

	// La methodde pour inserer les produits dans la table (Create du crud)
	public String create(Products products) {

		this.productsRepo.save(products);
		return "Produit enregistré avec succès !";
	}

	// La methodde pour lire tous les produits de la table (Read du crud)
	public List<Products> search() {
		return this.productsRepo.findAll();
	}

	// La methode pour lire les produits par id
	public Products read(long id) {
		Optional<Products> optionalProducts = this.productsRepo.findById(id);

		// On affiche le produit coorespondant à l'id si on le trouve dans le cas
		// contraire on affiche rien
		return optionalProducts.orElse(null);
	}

	// La methode pour faire la mise à jour des données des produits
	public void update(long id, Products products) {
		Products productsUpdate = this.read(id);

		if (productsUpdate.getId() == products.getId()) {
			productsUpdate.setName(products.getName());
			productsUpdate.setSky(products.getSky());
			productsUpdate.setPrice(products.getPrice());
			productsUpdate.setCurrency(products.getCurrency());
			productsUpdate.setBrand(products.getBrand());
			productsUpdate.setColor(products.getColor());
			productsUpdate.setDescription(products.getDescription());
			productsUpdate.setThumbmail(products.getThumbmail());
		}
	}

	// La methode pour supprimer tous les produits de la tables
	public String delete() {
		this.productsRepo.deleteAll();
		return "Tous les produits ont été supprimés avec succès !";
	}

	// La methode pour supprimer un produit par son id
	public String deleteAll(long id) {
		this.productsRepo.deleteById(id);
		return "Le produit a été supprimé avec succès !";
	}

}
