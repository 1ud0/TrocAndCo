package com.tac.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="photo")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_photo")
	private Integer idPhoto;
	
	@Column(name="url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name="proposition_id")
	private Proposition proposition;

	
	public Photo() {
	}


	public Integer getIdPhoto() {
		return idPhoto;
	}


	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Proposition getProposition() {
		return proposition;
	}


	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}

	

}
