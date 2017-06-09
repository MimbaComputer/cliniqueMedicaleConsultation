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
public class RendezVou implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 50)
	private String motif;
	@NotNull
	private boolean presence;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
	private Date trancheHoraire;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;

	public RendezVou() {
		super();
		
	}

	public RendezVou(String motif, boolean presence, Date trancheHoraire, Patient patient) {
		super();
		this.motif = motif;
		this.presence = presence;
		this.trancheHoraire = trancheHoraire;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public Date getTrancheHoraire() {
		return trancheHoraire;
	}

	public void setTrancheHoraire(Date trancheHoraire) {
		this.trancheHoraire = trancheHoraire;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
