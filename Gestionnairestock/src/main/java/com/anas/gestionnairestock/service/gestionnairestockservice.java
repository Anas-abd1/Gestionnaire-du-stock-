package com.anas.gestionnairestock.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.anas.gestionnairestock.entities.Categorie;
import com.anas.gestionnairestock.entities.gestionanirestock;

public interface gestionnairestockservice {
	
	gestionanirestock saveVoiture(gestionanirestock v);
	
	gestionanirestock updateVoiture(gestionanirestock v);
	
	 void deleteVoiture(gestionanirestock v);
	 
	 void deleteVoitureById(Long id);
	 
	 gestionanirestock getVoiture(Long id);
	 
	 List<gestionanirestock> getAllVoitures();
	 
	 //List<gestionanirestock> findByMarqueVoiture(String nomProduit);
	 
	 //List<gestionanirestock> findByMarqueVoitureContains(String nomProduit);
	 
	 List<gestionanirestock> findByMarquePrix (String nomProduit, Double prixProduit);
	 
	 List<gestionanirestock> findByCategorie (Categorie categorie);
	 
	 List<gestionanirestock> findByCategorieIdCat(Long idProduit);
	 
	 //<gestionanirestock> findByOrderByMarqueVoitureAsc();
	 
	 List<gestionanirestock> trierVoituresMarquePrix();
	 
	 Page<gestionanirestock> getAllVoituresParPage(int page, int size) ;
	}

