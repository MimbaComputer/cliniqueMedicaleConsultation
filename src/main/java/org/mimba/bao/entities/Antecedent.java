package org.mimba.bao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Antecedent implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max=50)
	private String typeAntecedent;
	@Size(max=100)
	@NotNull
	private String traitementIssue;
	@Size(max=50)
	private String periode;
	@NotNull
	@Size(max=100)
	private String antecedent;
	@NotNull
	@ManyToOne
	@JoinColumn(name="idPatient")
	private Patient patient;
	public Antecedent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Antecedent(String typeAntecedent, String traitementIssue, String periode, String antecedent,
			Patient patient) {
		super();
		this.typeAntecedent = typeAntecedent;
		this.traitementIssue = traitementIssue;
		this.periode = periode;
		this.antecedent = antecedent;
		this.patient = patient;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeAntecedent() {
		return typeAntecedent;
	}
	public void setTypeAntecedent(String typeAntecedent) {
		this.typeAntecedent = typeAntecedent;
	}
	public String getTraitementIssue() {
		return traitementIssue;
	}
	public void setTraitementIssue(String traitementIssue) {
		this.traitementIssue = traitementIssue;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getAntecedent() {
		return antecedent;
	}
	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
