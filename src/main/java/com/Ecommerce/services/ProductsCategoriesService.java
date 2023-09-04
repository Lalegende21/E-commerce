package com.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.entites.ProductsCategories;
import com.Ecommerce.repository.ProductsCategoriesRepo;

@Service
public class ProductsCategoriesService {

	private ProductsCategoriesRepo productsCategoriesService;

	public ProductsCategoriesService(ProductsCategoriesRepo productsCategoriesService) {
		this.productsCategoriesService = productsCategoriesService;
	}

	// La methodde pour inserer les catégories dans la table (Create du crud)
	public String create(ProductsCategories productsCategories) {

		// On verifie si aucune autre categorie n'a le même nom
		ProductsCategories productCategorieName = this.productsCategoriesService
				.findByName(productsCategories.getName());

		if (productCategorieName == null) {
			this.productsCategoriesService.save(productsCategories);
			return "Categorie créee avec succès !";
		}

		return "Categorie non crée !";
	}

	// La methodde pour lire toutes les catégories (Read du crud)
	public List<ProductsCategories> read() {
		return this.productsCategoriesService.findAll();
	}

	// La methodde pour lire les catégories par id
	public ProductsCategories read(long id) {
		Optional<ProductsCategories> optionalCategories = this.productsCategoriesService.findById(id);

		// si la catégorie existe on l'affiche dans le cas contraire on affice rien
		return optionalCategories.orElse(null);
	}

	// La methode pour faire la mise à jour des données des catégories
	public void update(long id, ProductsCategories productCategorie) {
		ProductsCategories categorieUpdate = this.read(id);

		if (categorieUpdate.getId() == productCategorie.getId()) {
			categorieUpdate.setName(productCategorie.getName());
		}
	}

	// La methode pour supprimer tous les catégories de la tables
	public String deleteAll() {
		this.productsCategoriesService.deleteAll();
		return "Toutes les catégories ont été supprimées avec succès !";
	}

	// La methode pour supprimer une catégorie par son id
	public String deleteId(long id) {
		this.productsCategoriesService.deleteById(id);
		return "Catégorie supprimée avec succès !";
	}

}
