package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Visite implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
	private Date date;
	@NotNull
	@Size(min=5, max=100)
	private String motif;
	@NotNull
	@Size(min=5, max=100)
	private String interrogatoire;
	@NotNull
	@Size(min=5, max=100)
	private String conclusion;
	@Size(min=5, max=100)
	private String examen;
	@NotNull
	private int honoraire;
	@ManyToOne
	@JoinColumn(name="idTypeCas")
	private TypeCa typeCas;
	@ManyToOne
	@JoinColumn(name="idPatient")
	private Patient patient;
	@OneToMany(mappedBy="visite")
	private Collection<Reglement> reglement;
	@OneToOne(mappedBy="visite")
	private Ordonnance ordonnance;
	public Visite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Visite(Date date, String motif, String interrogatoire, String conclusion, String examen, int honoraire,
			TypeCa typeCas, Patient patient, Ordonnance ordonnance) {
		super();
		this.date = date;
		this.motif = motif;
		this.interrogatoire = interrogatoire;
		this.conclusion = conclusion;
		this.examen = examen;
		this.honoraire = honoraire;
		this.typeCas = typeCas;
		this.patient = patient;
		this.ordonnance = ordonnance;
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
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getInterrogatoire() {
		return interrogatoire;
	}
	public void setInterrogatoire(String interrogatoire) {
		this.interrogatoire = interrogatoire;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public String getExamen() {
		return examen;
	}
	public void setExamen(String examen) {
		this.examen = examen;
	}
	public int getHonoraire() {
		return honoraire;
	}
	public void setHonoraire(int honoraire) {
		this.honoraire = honoraire;
	}
	public TypeCa getTypeCas() {
		return typeCas;
	}
	public void setTypeCas(TypeCa typeCas) {
		this.typeCas = typeCas;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Collection<Reglement> getReglement() {
		return reglement;
	}
	public void setReglement(Collection<Reglement> reglement) {
		this.reglement = reglement;
	}
	public Ordonnance getOrdonnance() {
		return ordonnance;
	}
	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}
	
	
}
