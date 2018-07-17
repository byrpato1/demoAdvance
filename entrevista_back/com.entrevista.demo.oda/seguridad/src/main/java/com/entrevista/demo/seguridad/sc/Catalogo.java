/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrevista.demo.seguridad.sc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
    
}
