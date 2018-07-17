package com.entrevista.demo.od.modelos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.entrevista.demo.od.enums.AprobaCreditoEnum;

@Entity
public class Credito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long creditoId;

	@Column(name="deudor_id")
	private Long deudorId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="deudor_id", insertable = false, updatable = false)
	private Deudor deudor;

	private Long monto;
	
	private Long tasa;
	
	private Integer plazo;
	
	private Long cuota;
	
	private AprobaCreditoEnum aprobacion;
		

	public Long getId() {
		return creditoId;
	}

	public void setId(Long creditoId) {
		this.creditoId = creditoId;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Long getTasa() {
		return tasa;
	}

	public void setTasa(Long tasa) {
		this.tasa = tasa;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Long getCuota() {
		return cuota;
	}

	public void setCuota(Long cuota) {
		this.cuota = cuota;
	}

	public Long getDeudorId() {
		return deudorId;
	}

	public void setDeudorId(Long deudorId) {
		this.deudorId = deudorId;
	}

	public Deudor getDeudor() {
		return deudor;
	}

	public void setDeudor(Deudor deudor) {
		this.deudor = deudor;
	}

	public AprobaCreditoEnum getAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(AprobaCreditoEnum aprobacion) {
		this.aprobacion = aprobacion;
	}
	
	
}
