package com.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Ecommerce.entites.PaiementMethode;
import com.Ecommerce.repository.PaiementMethodeRepo;

@Service
public class PaiementMethodeService {

	private PaiementMethodeRepo paiementMethode;

	public PaiementMethodeService(PaiementMethodeRepo paiementMethode) {
		this.paiementMethode = paiementMethode;
	}

	// La methodde pour inserer les méthodes de paiement dans la table (Create du
	// crud)
	public String create(PaiementMethode paiement) {
		this.paiementMethode.save(paiement);

		return "méthode de paiement enregistré avec succès !";
	}

	// La methodde pour lire tous les méthodes de paiement de la table (Read du
	// crud)
	public List<PaiementMethode> search() {
		return this.paiementMethode.findAll();
	}

	// La methode pour lire les méthodes de paiement par id
	public PaiementMethode read(long id) {
		Optional<PaiementMethode> optionalPaiement = this.paiementMethode.findById(id);

		// On affiche le paiement coorespondant à l'id si on le trouve dans le cas
		// contraire on affiche rien
		return optionalPaiement.orElse(null);
	}

	// La methode pour faire la mise à jour des données des méthodes de paiement
	public void update(long id, PaiementMethode paiement) {
		PaiementMethode updatePaiement = this.read(id);

		if (updatePaiement.getId() == paiement.getId()) {
			updatePaiement.setRef(paiement.getRef());
			;
			updatePaiement.setCode(paiement.getCode());
			updatePaiement.setExpired_at(paiement.getExpired_at());
		}
	}

	// La methode pour supprimer toutes les méthodes de paiement de la tables
	public String deleteAll() {
		this.paiementMethode.deleteAll();
		return "Toutes les méthodes de paiement ont été supprimées avec succès !";
	}

	// La methode pour supprimer une méthodes de paiement par son id
	public String deleteId(long id) {
		this.paiementMethode.deleteById(id);
		return "La méthode de paiement a été supprimé avec succès !";
	}

}
