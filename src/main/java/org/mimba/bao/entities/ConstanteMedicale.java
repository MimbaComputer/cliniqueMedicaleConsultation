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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ConstanteMedicale implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
	private Date date;
	@NotNull
	private double poids;
	@NotNull
	private double taille;
	@NotNull
	private int pas;
	@NotNull
	private int pad;
	@NotNull
	private int pouls;
	@NotNull
	private double temperature;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;

	public ConstanteMedicale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConstanteMedicale(Date date, double poids, double taille, int pas, int pad, int pouls, double temperature) {
		super();
		this.date = date;
		this.poids = poids;
		this.taille = taille;
		this.pas = pas;
		this.pad = pad;
		this.pouls = pouls;
		this.temperature = temperature;
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

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		this.pas = pas;
	}

	public int getPad() {
		return pad;
	}

	public void setPad(int pad) {
		this.pad = pad;
	}

	public int getPouls() {
		return pouls;
	}

	public void setPouls(int pouls) {
		this.pouls = pouls;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}

@Entity
class Patient implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "patient")
	private Collection<ConstanteMedicale> constanteMedicale;
	private CasASuivre CasASuivre;
	@OneToMany(mappedBy="patient")
	private Collection<Ordonnance> ordonnace;
	@OneToMany(mappedBy="patient")
	private Collection<Visite> visite;
	@OneToMany(mappedBy="patient")
	private Collection<Antecedent> antecedent;
	@OneToMany(mappedBy="patient")
	private Collection<RendezVou> rendezVous;
}