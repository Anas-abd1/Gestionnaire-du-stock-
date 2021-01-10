package com.anas.gestionnairestock.repos;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.anas.gestionnairestock.entities.Categorie;
import com.anas.gestionnairestock.entities.gestionanirestock;

@RepositoryRestResource(path = "rest")
public interface GestionnairestockRepository extends JpaRepository<gestionanirestock, Long>{
	
	//List<gestionanirestock> findByMarqueVoiture(String nomProduit);
	
	//List<gestionanirestock> findByMarqueVoitureContains(String nomProduit);
	
	
	@Query("select v from gestionanirestock v where v.nomProduit like %?1 and v.prixProduit > ?2") 
	List<gestionanirestock> findByMarquePrix (String nomProduit, Double prixProduit);

	@Query("select v from gestionanirestock v where v.categorie = ?1") 
	List<gestionanirestock> findByCategorie (Categorie categorie);
	
	List<gestionanirestock> findByCategorieIdCat(Long id);
	//List<gestionanirestock> findByOrderByMarqueVoitureAsc();
	
	@Query("select v from gestionanirestock v order by v.nomProduit ASC, v.prixProduit DESC")
	List<gestionanirestock> trierVoituresMarquePrix ();

}
