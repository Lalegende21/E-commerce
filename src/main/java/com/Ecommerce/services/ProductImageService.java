package com.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.entites.ProductImage;
import com.Ecommerce.repository.ProductsImageRepo;

@Service
public class ProductImageService {

	private ProductsImageRepo productImage;

	public ProductImageService(ProductsImageRepo productImage) {
		this.productImage = productImage;
	}

	// La methodde pour inserer les images de produits dans la table (Create du
	// crud)
	public String create(ProductImage productImage) {
		ProductImage image = this.productImage.findByUrl(productImage.getUrl());

		if (image == null) {
			this.productImage.save(productImage);
			return "Image insérée avec succès !";
		}

		return "Image non insérée !";
	}

	// La methodde pour lire toutes les images de produits de la table (Read du
	// crud)
	public List<ProductImage> search() {
		return this.productImage.findAll();
	}

	// La methode pour lire les images de produits par id
	public ProductImage read(long id) {
		Optional<ProductImage> productImage = this.productImage.findById(id);

		// On affiche les images de produit coorespondant à l'id si on le trouve dans le
		// cas
		// contraire on affiche rien
		return productImage.orElse(null);
	}

	// La methode pour faire la mise à jour des données des images
	public void update(long id, ProductImage productImage) {
		ProductImage image = this.read(id);

		if (image.getId() == productImage.getId()) {
			image.setUrl(productImage.getUrl());
		}
	}

	// La methode pour supprimer toutes les images de produit de la tables
	public String deleteAll() {
		this.productImage.deleteAll();
		return "Toutes les images de produits ont été supprimées avec succès !";
	}

	// La methode pour supprimer une image de produit par son id
	public String deleteId(long id) {
		this.productImage.deleteById(id);
		return "Image supprimée avec succès !";
	}

}
