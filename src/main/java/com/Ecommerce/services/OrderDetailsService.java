package com.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.entites.OrderDetails;
import com.Ecommerce.repository.OrderdetailRepo;

@Service
public class OrderDetailsService {

	private OrderdetailRepo orderDetail;

	public OrderDetailsService(OrderdetailRepo orderDetail) {
		this.orderDetail = orderDetail;
	}

	// La methodde pour inserer les factures dans la table (Create du crud)
	public String create(OrderDetails orderDetails) {
		this.orderDetail.save(orderDetails);
		return "Facture enregistrée avec succès !";
	}

	// La methodde pour lire toutes les factures de la table (Read du crud)
	public List<OrderDetails> search() {
		return this.orderDetail.findAll();
	}

	// La methode pour lire les factures par id
	public OrderDetails read(long id) {
		Optional<OrderDetails> optionalDetails = this.orderDetail.findById(id);

		/*
		 * On affiche la facture correspondant à l'id si on la trouve dans le cas
		 * contraire on affiche rien
		 */
		return optionalDetails.orElse(null);
	}

	// La methode pour faire la mise à jour des données des factures
	public String update(long id, OrderDetails orderDetails) {
		OrderDetails orderUpdate = this.read(id);

		if (orderUpdate.getId() == orderDetails.getId()) {
			orderUpdate.setPrice(orderDetails.getPrice());
			orderUpdate.setStatus(orderDetails.getStatus());
			orderUpdate.setAmount(orderDetails.getAmount());

			return "Mise à jour effectué avec succès !";
		}

		return "Mise à jour impossible !";
	}

	// La methode pour supprimer toutes les factures de la table
	public String deleteAll() {
		this.orderDetail.deleteAll();
		return "Toutes les factures ont été supprimées avec succès !";
	}

	// La methode pour supprimer un paiement par son id
	public String deleteId(long id) {
		this.orderDetail.deleteById(id);
		return "Facture supprimée avec succès !";
	}

}
