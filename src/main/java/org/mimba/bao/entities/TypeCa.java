package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;


@Entity
public class TypeCa implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="idCasASuivre")
	private CasASuivre casASuivre;
	@Size(min=5, max=100)
	private String libelle;
	@Size(min=5, max=100)
	private String examenTypique;
	@OneToMany(mappedBy="typeCas")
	private Collection<Visite> visite;
	@OneToMany(mappedBy="typeCas")
	private Collection<Ordonnance> ordonnance;
	public TypeCa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeCa(String libelle, String examenTypique) {
		super();
		this.libelle = libelle;
		this.examenTypique = examenTypique;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public CasASuivre getCasASuivre() {
		return casASuivre;
	}
	public void setCasASuivre(CasASuivre casASuivre) {
		this.casASuivre = casASuivre;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getExamenTypique() {
		return examenTypique;
	}
	public void setExamenTypique(String examenTypique) {
		this.examenTypique = examenTypique;
	}
	public Collection<Visite> getVisite() {
		return visite;
	}
	public void setVisite(Collection<Visite> visite) {
		this.visite = visite;
	}
	public Collection<Ordonnance> getOrdonnance() {
		return ordonnance;
	}
	public void setOrdonnance(Collection<Ordonnance> ordonnance) {
		this.ordonnance = ordonnance;
	}

	
	
}
