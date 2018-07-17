package com.entrevista.demo.seguridad.enums;

public enum RolEnum {

	ASE("ASESOR"),
	A("ADMINISTRADOR");
	
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	private RolEnum(String label){
		this.label=label;
	}
}
