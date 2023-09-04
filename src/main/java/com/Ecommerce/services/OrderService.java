package com.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.entites.Orders;
import com.Ecommerce.repository.OrderRepo;

@Service
public class OrderService {

	private OrderRepo orderRepo;

	public OrderService(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}

	// La methodde pour inserer les paiements dans la table (Create du crud)
	public String create(Orders order) {
		this.orderRepo.save(order);
		return "Paiement enregistrée avec succès !";
	}

	// La methodde pour lire tous les paiements de la table (Read du crud)
	public List<Orders> search() {
		return this.orderRepo.findAll();
	}

	// La methode pour lire les paiements par id
	public Orders read(long id) {
		Optional<Orders> orderOptional = this.orderRepo.findById(id);

		// On affiche la facture coorespondant à l'id si on le trouve dans le cas
		// contraire on affiche rien
		return orderOptional.orElse(null);
	}

	// La methode pour faire la mise à jour des données des paiements
	public void update(long id, Orders order) {
		Orders orderUpdate = this.read(id);

		if (orderUpdate.getId() == order.getId()) {
			orderUpdate.setTotal(order.getTotal());
			orderUpdate.setCurrency(order.getCurrency());
			orderUpdate.setTaxe(order.getTaxe());
			orderUpdate.setDiscount(order.getDiscount());
		}
	}

	// La methode pour supprimer tous les paiements de la tables
	public String deleteAll() {
		this.orderRepo.deleteAll();
		return "Toutes les paiements ont été supprimés avec succès !";
	}

	// La methode pour supprimer un paiement par son id
	public String deleteid(long id) {
		this.orderRepo.deleteById(id);
		return "Paiement supprimé avec succès !";
	}

}
