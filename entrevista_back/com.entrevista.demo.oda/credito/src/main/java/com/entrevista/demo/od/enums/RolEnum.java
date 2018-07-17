package com.entrevista.demo.od.enums;

public enum RolEnum {

	
	AY("AYUDANTE"),
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
