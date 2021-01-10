package com.anas.gestionnairestock.controllers;


	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;

import com.anas.gestionnairestock.entities.gestionanirestock;
import com.anas.gestionnairestock.service.gestionnairestockservice;
	@Controller
	public class gestionnairestockcontroller {
		
		@Autowired
		gestionnairestockservice voituretService;
		
		@RequestMapping("/showCreate")
		public String showCreate(ModelMap modelMap)
		{
		modelMap.addAttribute("voiture", new gestionanirestock());
		modelMap.addAttribute("mode", "new");
		return "formgestionnairestock";
		}
		
		@RequestMapping("/saveVoiture")
		public String saveProduit(@Valid gestionanirestock voiture,
		BindingResult bindingResult)
		{
		if (bindingResult.hasErrors()) return "formgestionnaire_stock";
		voituretService.saveVoiture(voiture);
		return "formgestionnairestock";
		}
		
		
		
		@RequestMapping("/ListeVoitures")
		public String listeVoitures(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{
			Page<gestionanirestock> v = voituretService.getAllVoituresParPage(page, size);
			modelMap.addAttribute("voitures", v);
			modelMap.addAttribute("pages", new int[v.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			return "listeVoitures";
		}
		
		@RequestMapping("/supprimerVoiture")
		public String supprimerVoiture(@RequestParam("id") Long id,
		ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
		{
		voituretService.deleteVoitureById(id);
		Page<gestionanirestock> v = voituretService.getAllVoituresParPage(page,
				size);
				modelMap.addAttribute("gestionnairestock", v);
				modelMap.addAttribute("pages", new int[v.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
		return "listeVoitures";
		}
		
		
		@RequestMapping("/modifierVoiture")
		public String editerVoiture(@RequestParam("id") Long id,ModelMap modelMap)
		{
		gestionanirestock v= voituretService.getVoiture(id);
		modelMap.addAttribute("voiture", v);
		modelMap.addAttribute("mode", "edit");
		return "formVoiture";
		}
		
		
		@RequestMapping("/updateVoiture")
		public String updateVoiture(@ModelAttribute("voiture") gestionanirestock voiture,
		@RequestParam("date") String date,ModelMap modelMap) throws ParseException
		{
			//conversion de la date 
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateArrive = dateformat.parse(String.valueOf(date));
			voiture.setDateCreation(dateArrive);
		
			voituretService.updateVoiture(voiture);
			List<gestionanirestock> v = voituretService.getAllVoitures();
			modelMap.addAttribute("voiture", v);
			return "listeVoitures";
			}
		
		
}

