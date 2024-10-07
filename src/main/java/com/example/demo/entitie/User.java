package com.example.demo.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String nom ;
	private String prenom ;
	private String email ;
	private String password ; 
	private String username ;
	@ManyToOne
	private Role role ; 
	
		
	
	
}
