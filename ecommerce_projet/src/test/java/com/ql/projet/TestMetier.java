package com.ql.projet;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ql.projet.metier.IAdminMetier;
import com.ql.projet.model.Categorie;
import com.ql.projet.model.Produit;

public class TestMetier {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCategorie() {
		try {
			ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAdminMetier metier = (IAdminMetier) context.getBean("metier");
			List<Categorie> cts1 = metier.listCategories();
			metier.ajouterCategorie(new Categorie("ordinateurs2", "ordinateurs2", null, "image1.jpg"));
			metier.ajouterCategorie(new Categorie("ordinateurs3", "ordinateurs3", null, "image2.jpg"));
			List<Categorie> cts2 = metier.listCategories();
			assertTrue(cts1.size()+2 == cts2.size());
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}	
	}
	
	@Test
	public void testProduit() {
		try {
			ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IAdminMetier metier = (IAdminMetier) context.getBean("metier");
			List<Produit> prd1 = metier.listProduits();
			
			metier.ajouterProduit(new Produit("designation", "description", 122, true, null, 2) , 1L);
			metier.ajouterProduit(new Produit("designation1", "description1", 222, true, null, 2) , 2L);
			List<Produit> prd2 = metier.listProduits();
			assertTrue(prd1.size()+2 == prd2.size());
		
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}	
	}

}
