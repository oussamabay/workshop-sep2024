package com.example.demo.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String nom ;
	private String description ; 
	private String datedebut ;
	@ManyToOne
	private User user ;
	@ManyToOne
	private Categorie cat ;
}
