package com.anas.gestionnairestock.service;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.anas.gestionnairestock.entities.Categorie;
import com.anas.gestionnairestock.entities.gestionanirestock;
import com.anas.gestionnairestock.repos.GestionnairestockRepository;

@Service
public class gestionnairestockserviceimpl implements gestionnairestockservice {
	@Autowired
	
	GestionnairestockRepository voitureRepository;
	
	@Override
	public gestionanirestock saveVoiture( gestionanirestock v) {
		return voitureRepository.save(v);
	}

	public gestionanirestock updateVoiture(gestionanirestock v) {
		return voitureRepository.save(v);
	}

	@Override
	public void deleteVoiture(gestionanirestock v) {
		voitureRepository.delete(v);
		
	}

	@Override
	public void deleteVoitureById(Long idProduit) {
		voitureRepository.deleteById(idProduit);
	}

	@Override
	public gestionanirestock getVoiture(Long idProduit) {
		return voitureRepository.findById(idProduit).get();
	}

	@Override
	public List<gestionanirestock> getAllVoitures() {
		return voitureRepository.findAll();
	}

	@Override
	public Page<gestionanirestock> getAllVoituresParPage(int page, int size) {
		return voitureRepository.findAll(PageRequest.of(page, size));
	}
	
	//@Override
	//public List<gestionanirestock> findByMarqueVoiture(String nomProduit) {
	//return voitureRepository.findByMarqueVoiture(nomProduit);
	//}
	//@Override 
	//public List<gestionanirestock> findByMarqueVoitureContains(String nomProduit) 
	//{
		//return voitureRepository.findByMarqueVoitureContains(nomProduit);
	//}
	@Override
	public List<gestionanirestock> findByMarquePrix(String nomProduit, Double prixProduit) {
		return voitureRepository.findByMarquePrix(nomProduit, prixProduit);
	}
	@Override
	public List<gestionanirestock> findByCategorie(Categorie categorie) {
	return voitureRepository.findByCategorie(categorie);
	}
	@Override
	public List<gestionanirestock> findByCategorieIdCat(Long idProduit) {
	return voitureRepository.findByCategorieIdCat(idProduit);
	}
	//@Override
	//public List<gestionanirestock> findByOrderByMarqueVoitureAsc() {
	//return voitureRepository.findByOrderByMarqueVoitureAsc();
	//}
	@Override
	public List<gestionanirestock> trierVoituresMarquePrix() {
	return voitureRepository.trierVoituresMarquePrix();
	}

	//@Override
	//public List<gestionanirestock> findByMarqueVoitureContains(String nomProduit) {
		// TODO Auto-generated method stub
		//return null;
	//}

	

}
