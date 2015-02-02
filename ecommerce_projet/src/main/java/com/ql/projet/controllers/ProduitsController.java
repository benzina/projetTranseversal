package com.ql.projet.controllers;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ql.projet.metier.IAdminMetier;
import com.ql.projet.model.Produit;

@Controller
@RequestMapping(value="/adminProd")
public class ProduitsController {
	@Autowired
	private IAdminMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("produit",new Produit());
		model.addAttribute("categories",metier.listCategories());
		model.addAttribute("produits",metier.listProduits());
		return "produits";
	}
	@RequestMapping(value="/saveProd")
	public String saveCat(@Valid Produit p, BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException{
		if(bindingResult.hasErrors()){
			model.addAttribute("categories",metier.listCategories());
			model.addAttribute("produits",metier.listProduits());
			return ("produits");
		}
		
		if(!file.isEmpty()){
			String path=System.getProperty("java.io.tmpdir");
			p.setPhoto(file.getOriginalFilename());
			Long idP=null;
			if(p.getIdProduit()==null){
				idP=metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			}
			else{
				metier.modifierProduit(p);
				idP=p.getIdProduit();
			}
			file.transferTo(new File(path+"/"+"PROD_"+idP+"_"+file.getOriginalFilename()));
		}
		if(p.getIdProduit()!=null){
			if(file.isEmpty()){ 
			Produit pro=metier.getProduit(p.getIdProduit());
			p.setPhoto(pro.getPhoto());
			}
			metier.modifierProduit(p);
		}else{
			if(p.getIdProduit()==null){
				metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			}
			else{
				metier.modifierProduit(p);	
				}
		}
		model.addAttribute("produit",new Produit());
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		return "produits";
	}
	@RequestMapping(value="photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(Long idProd) throws IOException{
		Produit p = metier.getProduit(idProd);
		File f =new File(System.getProperty("java.io.tmpdir")+"/PROD_"+idProd+"_"+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	@RequestMapping(value="/suppProd")
	public String supp(Long idProd, Model model){
		metier.supprimerProduit(idProd);
		model.addAttribute("produit",new Produit());
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		return "produits";
	}
	
	@RequestMapping(value="/editProd")
	public String edit(Long idProd, Model model){
		Produit p =metier.getProduit(idProd);
		model.addAttribute("produit",p); 
		model.addAttribute("produits",metier.listProduits());
		model.addAttribute("categories",metier.listCategories());
		return "produits";
	}
	
}
