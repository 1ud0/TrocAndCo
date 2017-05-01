package com.tac.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@Table(name="tag")
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tag")
	private Integer idTag;

	@Column(name="intitule")
	private String intitule;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;

	public Tag() {
	}

	public Integer getIdTag() {
		return this.idTag;
	}

	public void setIdTag(Integer idTag) {
		this.idTag = idTag;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}