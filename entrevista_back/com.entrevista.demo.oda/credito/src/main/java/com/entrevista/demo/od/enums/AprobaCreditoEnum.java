package com.entrevista.demo.od.enums;

public enum AprobaCreditoEnum {

	
	R("RECHAZADO"),
	A("APROBADO"),
	EN("EN REVISIÓN");
	
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	private AprobaCreditoEnum(String label){
		this.label=label;
	}
}
