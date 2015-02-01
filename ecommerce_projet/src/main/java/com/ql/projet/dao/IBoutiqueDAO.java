package com.ql.projet.dao;



import java.util.List;



import com.ql.projet.model.Categorie;
import com.ql.projet.model.Client;
import com.ql.projet.model.Commande;
import com.ql.projet.model.Panier;
import com.ql.projet.model.Produit;
import com.ql.projet.model.Role;
import com.ql.projet.model.User;

public interface IBoutiqueDAO {

	//gestion des categories
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	
	//gestion des produits
	public Long ajouterProduit(Produit p, Long idCat);
	public List<Produit> listProduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit idP);
	
	//gestion des users
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
	
	//gestion des users
	public Commande enregistrerComande(Panier p,Client c);
	
	//gestion des clients
	
	public Long ajouterClient(Client cl);
	public void modifierClient(Client cl);
	public void supprimerClient(Long idClient);
	public List<Client> listClients();
	public Client getClient(Long idClient);
	
	
	
}
