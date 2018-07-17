package com.entrevista.demo.od.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RelacionPersona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long relacionPersonaId;

	@Column(name="persona_id")
	private Long personaId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="persona_id", insertable = false, updatable = false)
	private Persona persona;
	
	@Column(name = "catalogo_id")
	private Long catalogoId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catalogo_id", insertable = false, updatable = false)
	private Catalogo tipoRelacion;
	
	public Long getId() {
		return relacionPersonaId;
	}

	public void setId(Long relacionPersonaId) {
		this.relacionPersonaId = relacionPersonaId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Long getRelacionPersonaId() {
		return relacionPersonaId;
	}

	public void setRelacionPersonaId(Long relacionPersonaId) {
		this.relacionPersonaId = relacionPersonaId;
	}

	public Long getCatalogoId() {
		return catalogoId;
	}

	public void setCatalogoId(Long catalogoId) {
		this.catalogoId = catalogoId;
	}
	
}
