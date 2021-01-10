package com.anas.gestionnairestock.resetcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anas.gestionnairestock.entities.gestionanirestock;
import com.anas.gestionnairestock.service.gestionnairestockservice;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class resetcontrollers {
	@Autowired
	
	gestionnairestockservice voitureService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<gestionanirestock> getAllProduits() 
	{
		return voitureService.getAllVoitures();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public gestionanirestock getVoitureById(@PathVariable("idProduit") Long id) 
	{ 
		return voitureService.getVoiture(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public gestionanirestock createProduit(@RequestBody gestionanirestock voiture) {
	return voitureService.saveVoiture(voiture);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public gestionanirestock updateProduit(@RequestBody gestionanirestock voiture) {
	return voitureService.updateVoiture(voiture);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteVoiture(@PathVariable("idProduit") Long id)
	{
		voitureService.deleteVoitureById(id);
	}
	
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<gestionanirestock> getVoituresByCatId(@PathVariable("idCat") Long idCat) {
	return voitureService.findByCategorieIdCat(idCat);
	}
	

}
