package com.anas.gestionnairestock.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
	@Entity
	public class gestionanirestock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	@NotNull
	@Size (min = 0)
	private Double poidsProduit ;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomProduit;
	
	@NotNull
	@Size (min = 0)
	private Double prixProduit;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	public gestionanirestock() 
	{
		super();
	}
	public gestionanirestock(String nomProduit, Double poidsProduit, Double prixProduit, Date dateCreation) 
	{
		super();
	
		this.nomProduit = nomProduit;
		this.poidsProduit=poidsProduit;
		this.prixProduit = prixProduit;
		this.dateCreation = dateCreation;
		
	}
	public Long getIdProduit() 
		{
			return idProduit;
		}
		public void setIdProduit(Long idProduit)
		{
			this.idProduit = idProduit;
		}
		public String getNomProduit()
		{
			return nomProduit;
		}
		public void setNomProduit(String nomProduit) 
		{
			this.nomProduit = nomProduit;
		}
		public Double getPrixProduit() 
		{
			return prixProduit;
		}
		public void setPrixProduit(Double prixProduit) 
		{
			this.prixProduit = prixProduit;
		}
		public Date getDateCreation() 
		{
			return dateCreation;
		}
		public void setDateCreation(Date dateCreation) 
		{
			this.dateCreation = dateCreation;
		}
		public Double getPoidsProduit() 
		{
			return poidsProduit;
		}
		public void setPoidsProduit(Double poidsProduit) 
		{
			this.poidsProduit = poidsProduit;
		}
		
		@Override
		public String toString() 
		{
			return "gestionanirestock [idProduit=" + idProduit + ", poidsProduit=" + poidsProduit + ", nomProduit="
					+ nomProduit + ", prixProduit=" + prixProduit + ", dateCreation=" + dateCreation + "]";
		}

		public Categorie getCategorie() 
		{
			return categorie;
		}



		public void setCategorie(Categorie categorie) 
		{
			this.categorie = categorie;
		}
		
		
		}


