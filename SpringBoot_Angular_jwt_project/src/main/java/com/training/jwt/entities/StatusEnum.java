package com.training.jwt.entities;

public enum StatusEnum {
	DIRECTEUR("directeur"),
	DIRECTEUR_ADJOINT("directeur_adjoint"),
	PRESIDENT("président"),
	ADHERENT("adhérent")
	;
	
	private String name;

	private StatusEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
