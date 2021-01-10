package com.anas.gestionnairestock.entities;



@org.springframework.data.rest.core.config.Projection(name = "nomProduit", types = { gestionanirestock.class })
public interface Projection {
	public String getNomProduit(); 

}
