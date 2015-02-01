package com.ql.projet.metier;

import java.util.List;




import com.ql.projet.model.Categorie;
import com.ql.projet.model.Produit;
import com.ql.projet.model.Role;
import com.ql.projet.model.User;

public interface IAdminMetier extends Internaute{
	    //gestion des categories
		public Long ajouterCategorie(Categorie c);
		public void supprimerCategorie(Long idCat);
		public void modifierCategorie(Categorie c);
		public void ajouterUser(User u); 
		public void attribuerRole(Role r,Long userID);
		
		//gestion des produits
		public Long ajouterProduit(Produit p,Long idCat);
		public void supprimerProduit(Long idP);
		public void modifierProduit(Produit p);
		
		
		
}
