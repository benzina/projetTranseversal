package com.ql.projet.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	@NotEmpty
	private String nomClient;
	@NotEmpty
	private String prenomClient;
	private String adresse;
	@Email
	private String email;
	private String telephone;
	private String codeReduction;
	private boolean isFidel;
	@Size(min=4)
	private String login;
	@Size(min=4)
	private String password;
	
	@OneToMany(mappedBy="client")
	private Collection<Commande> commandes;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nomClient, String prenomClient, String adresse,
			String email, String telephone, String codeReduction,
			boolean isFidel, String login, String password,
			Collection<Commande> commandes) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.codeReduction = codeReduction;
		this.isFidel = isFidel;
		this.login = login;
		this.password = password;
		this.commandes = commandes;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCodeReduction() {
		return codeReduction;
	}
	public void setCodeReduction(String codeReduction) {
		this.codeReduction = codeReduction;
	}
	public boolean isFidel() {
		return isFidel;
	}
	public void setFidel(boolean isFidel) {
		this.isFidel = isFidel;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
}
