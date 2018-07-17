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
public class Deudor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long deudorId;

	@Column(name="persona_id")
	private Long personaId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="persona_id", insertable = false, updatable = false)
	private Persona persona;

	private Long ingreso;
	
	private String direccion;
	
	private String numeroDireccion;
	
	private String telefono;
	
	@Column(name = "direccion_id")
	private Long direccionId;

	@Column(name = "telefono_id")
	private Long telefonoId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "direccion_id", insertable = false, updatable = false)
	private Catalogo tipoDireccion;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "telefono_id", insertable = false, updatable = false)
	private Catalogo tipoTelefono;

	
	public Long getId() {
		return deudorId;
	}

	public void setId(Long deudorId) {
		this.deudorId = deudorId;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroDireccion() {
		return numeroDireccion;
	}

	public void setNumeroDireccion(String numeroDireccion) {
		this.numeroDireccion = numeroDireccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIngreso() {
		return ingreso;
	}

	public void setIngreso(Long ingreso) {
		this.ingreso = ingreso;
	}
	
	
	
}
