package com.tac.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="departement")
@NamedQuery(name="Departement.findAll", query="SELECT d FROM Departement d")
public class Departement implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_deptartement")
	private Integer idDepartement;
	
	@Column(name="nom_departement")
	private String nomDepartement;
	
	@Column(name="num_departement")
	private String numDepartement;

	
	public Departement() {
	}

	public Integer getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Integer idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public String getNumDepartement() {
		return numDepartement;
	}

	public void setNumDepartement(String numDepartement) {
		this.numDepartement = numDepartement;
	}
	
}
