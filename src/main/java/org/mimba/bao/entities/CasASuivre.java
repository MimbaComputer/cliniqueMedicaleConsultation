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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CasASuivre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 5, max = 50)
	private String etatTraitement;
	@Size(min = 5, max = 100)
	private String histoireMaladie;
	@Size(max = 100)
	private String remarque;
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
	@OneToMany(mappedBy = "casASuivre")
	// @JoinTable(name = "CAASUIVRE_TYPECAS", joinColumns = @JoinColumn(name =
	// "NUM_CAASUIVRE"), inverseJoinColumns = @JoinColumn(name = "NUM_TYPECAS"))
	private Collection<TypeCa> typeCas;
	@NotNull
	@OneToMany(mappedBy = "casASuivre")
	private Collection<Imagerie> imagerie;

	public CasASuivre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CasASuivre(String etatTraitement, String histoireMaladie, String remarque, Patient patient,
			Collection<TypeCa> typeCas) {
		super();
		this.etatTraitement = etatTraitement;
		this.histoireMaladie = histoireMaladie;
		this.remarque = remarque;
		this.patient = patient;
		this.typeCas = typeCas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtatTraitement() {
		return etatTraitement;
	}

	public void setEtatTraitement(String etatTraitement) {
		this.etatTraitement = etatTraitement;
	}

	public String getHistoireMaladie() {
		return histoireMaladie;
	}

	public void setHistoireMaladie(String histoireMaladie) {
		this.histoireMaladie = histoireMaladie;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Collection<TypeCa> getTypeCas() {
		return typeCas;
	}

	public void setTypeCas(Collection<TypeCa> typeCas) {
		this.typeCas = typeCas;
	}

	public Collection<Imagerie> getImagerie() {
		return imagerie;
	}

	public void setImagerie(Collection<Imagerie> imagerie) {
		this.imagerie = imagerie;
	}

}

@Entity
class Imagerie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idCasASuivre")
	private CasASuivre casASuivre;

}