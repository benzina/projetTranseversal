package com.ql.projet.metier;

import java.util.List;






import org.springframework.transaction.annotation.Transactional;

import com.ql.projet.dao.IBoutiqueDAO;
import com.ql.projet.model.Categorie;
import com.ql.projet.model.Client;
import com.ql.projet.model.Commande;
import com.ql.projet.model.Panier;
import com.ql.projet.model.Produit;
import com.ql.projet.model.Role;
import com.ql.projet.model.User;

@Transactional
public class BoutiqueMetierImpl implements IAdminMetier {

	private IBoutiqueDAO dao;
	
	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {

		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {

		dao.modifierProduit(p);
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listProduits() {
		return dao.listProduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		return dao.produitParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		return dao.enregistrerComande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {

		dao.supprimerCategorie(idCat);
	}

	@Override
	public void modifierCategorie(Categorie c) {

		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {

		dao.ajouterUser(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {

		dao.attribuerRole(r, userID);
	}

	@Override
	public Commande enregistrerComande(Panier p, Client c) {
		
		return dao.enregistrerComande(p, c);
	}

	@Override
	public Long ajouterClient(Client cl) {
		
		return dao.ajouterClient(cl);
	}

	@Override
	public void modifierClient(Client cl) {

		dao.modifierClient(cl);
		
	}

	@Override
	public void supprimerClient(Long idClient) {

		dao.supprimerClient(idClient);
		
	}

	@Override
	public List<Client> listClients() {
		
		return dao.listClients();
	}

	@Override
	public Client getClient(Long idClient) {
		
		return dao.getClient(idClient);
	}

}
