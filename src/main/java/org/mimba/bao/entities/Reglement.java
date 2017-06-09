package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reglement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(pattern="yyyy-mm-dd hh:mm")
	private Date date;
	@NotNull
	private String typePaiement;
	@Size(max=50)
	private String remarque;
	@NotNull
	private int valeur;
	@NotNull
	@ManyToOne
	@JoinColumn(name="idVisite")
	private Visite visite;
	public Reglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reglement(Date date, String typePaiement, int valeur, Visite visite) {
		super();
		this.date = date;
		this.typePaiement = typePaiement;
		this.valeur = valeur;
		this.visite = visite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	public Visite getVisite() {
		return visite;
	}
	public void setVisite(Visite visite) {
		this.visite = visite;
	}
	
	
}
