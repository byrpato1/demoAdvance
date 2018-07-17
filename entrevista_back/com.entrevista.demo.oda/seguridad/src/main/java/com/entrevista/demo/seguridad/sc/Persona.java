/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrevista.demo.seguridad.sc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long personaId;
	
	private String nombres;
	
	private String apellidos;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	private String numeroIdentificacion;
	
	private Long cargasFamiliares;

	@Column(name = "direccion_id")
	private Long direccionId;

	@Column(name = "telefono_id")
	private Long telefonoId;

	@Column(name = "estado_civil_id")
	private Long estadoCivilId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "direccion_id", insertable = false, updatable = false)
	private Catalogo direccion;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "telefono_id", insertable = false, updatable = false)
	private Catalogo telefono;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_civil_id", insertable = false, updatable = false)
	private Catalogo estadoCivil;

	public Long getId() {
		return personaId;
	}

	public void setId(Long id) {
		this.personaId = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getEstadoCivilId() {
		return estadoCivilId;
	}

	public void setEstadoCivilId(Long estadoCivilId) {
		this.estadoCivilId = estadoCivilId;
	}

	public Catalogo getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Catalogo estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public Long getCargasFamiliares() {
		return cargasFamiliares;
	}

	public void setCargasFamiliares(Long cargasFamiliares) {
		this.cargasFamiliares = cargasFamiliares;
	}

	public Long getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(Long direccionId) {
		this.direccionId = direccionId;
	}

	public Long getTelefonoId() {
		return telefonoId;
	}

	public void setTelefonoId(Long telefonoId) {
		this.telefonoId = telefonoId;
	}

	public Catalogo getDireccion() {
		return direccion;
	}

	public void setDireccion(Catalogo direccion) {
		this.direccion = direccion;
	}

	public Catalogo getTelefono() {
		return telefono;
	}

	public void setTelefono(Catalogo telefono) {
		this.telefono = telefono;
	}
	
	
	
}
