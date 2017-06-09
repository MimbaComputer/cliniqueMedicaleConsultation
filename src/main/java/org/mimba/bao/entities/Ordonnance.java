package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ordonnance implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max=100)
	private String prescription;
	@NotNull
	@Size(max=100)
	private String prise;
	@NotNull
	@DateTimeFormat(pattern="yyyy-mm-dd hh:mm")
	private Date date;
	@ManyToOne
	@JoinColumn(name="idTypeCas")
	private TypeCa typeCas;
	@ManyToOne
	@JoinColumn(name="idPatient")
	private Patient patient;
	@OneToOne
	private Visite visite;
	public Ordonnance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ordonnance(String prescription, String prise, Date date, TypeCa typeCas, Patient patient, Visite visite) {
		super();
		this.prescription = prescription;
		this.prise = prise;
		this.date = date;
		this.typeCas = typeCas;
		this.patient = patient;
		this.visite = visite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getPrise() {
		return prise;
	}
	public void setPrise(String prise) {
		this.prise = prise;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public Visite getVisite() {
		return visite;
	}
	public void setVisite(Visite visite) {
		this.visite = visite;
	}
	
	
	
}
