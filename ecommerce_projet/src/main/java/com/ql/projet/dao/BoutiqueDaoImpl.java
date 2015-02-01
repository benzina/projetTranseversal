package com.ql.projet.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ql.projet.model.Categorie;
import com.ql.projet.model.Client;
import com.ql.projet.model.Commande;
import com.ql.projet.model.LigneCommande;
import com.ql.projet.model.Panier;
import com.ql.projet.model.Produit;
import com.ql.projet.model.Role;
import com.ql.projet.model.User;

public class BoutiqueDaoImpl implements IBoutiqueDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		Categorie c=em.find(Categorie.class, idCat);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		Categorie c=getCategorie(idCat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listProduits() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req=em.createQuery("select p from Produit p where p.designation like :d or p.description like :d");
		req.setParameter("d", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitParCategorie(Long idCat) {
		Query req=em.createQuery("select p from Produit p where p.categorie.idCategorie = :cat");
		req.setParameter("cat", idCat);
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query req=em.createQuery("select p from Produit p where p.selected=true");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
		return em.find(Produit.class, idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		Produit p =em.find(Produit.class, idP);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit idP) {
		em.merge(idP);
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		User u=em.find(User.class, userID);
		u.getRoles().add(r);
		em.persist(r);
	}

	@Override
	public Commande enregistrerComande(Panier p, Client c) {
		em.persist(c);
		Commande cmd=new Commande();
		cmd.setDateCommande(new Date());
		cmd.setItems(p.getItems());
		for(LigneCommande lc:p.getItems()){
			em.persist(lc);
		}
		em.persist(cmd);
		return cmd;
	}

	@Override
	public Long ajouterClient(Client cl) {
		
		em.persist(cl);
		return cl.getIdClient();
	}

	@Override
	public void modifierClient(Client cl) {
		em.merge(cl);
		
	}

	@Override
	public void supprimerClient(Long idClient) {
		Client client = em.find(Client.class, idClient);
		em.remove(client);
		
	}

	@Override
	public List<Client> listClients() {
		Query req=em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public Client getClient(Long idClient) {
		
		return em.find(Client.class, idClient);
	}

}
