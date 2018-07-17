/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrevista.demo.od.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL )
public class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long catalogoId;
	
	private String descripcion;
	
	private String valor;
	
	private Boolean estado;
	
	@Column(name = "catalogoPadreId", nullable = true)
	private Long catalogoPadreId;

	public Long getId() {
		return catalogoId;
	}

	public void setId(Long id) {
		this.catalogoId = id;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Long getCatalogoPadreId() {
		return catalogoPadreId;
	}

	public void setCatalogoPadreId(Long catalogoPadreId) {
		this.catalogoPadreId = catalogoPadreId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
    
}
