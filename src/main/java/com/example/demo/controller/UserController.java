package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Role;
import com.example.demo.entitie.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;


@RestController
@RequestMapping("user")
public class UserController {
	
@Autowired
private UserRepository userrespo ;
@Autowired
private RoleRepository rolerepos ; 
/*
 * Getmapping (affichage)
 * Postmapping (cretaion)
 * DeleteMapping(suppression)
 * Putmappring(modification)
 */


@PostMapping("/ajouter")
public String ajouter(@RequestBody User u) {
	this.userrespo.save(u);
	return "enregistrer avec succées";
}


@PostMapping("/ajouteravectest")
public String ajouteravectest(@RequestBody User u) {
	
	User user = this.userrespo.findByEmail(u.getEmail());
	if(user==null) {
		this.userrespo.save(u);
		return "enregistrer avec succées";
		
	}
	else {
		return "email existe deja";
	}
}

//@PreAuthorize("hasAuthority('Admin')")

@PreAuthorize("hasAnyAuthority('Admin','Formateur')")

@GetMapping("/afficher")
public List<User> afficher(){
return this.userrespo.findAll();
}

@GetMapping("/afficherbyid")
public User afficherbbyid(Long id){
	User u = this.userrespo.findById(id).get();
return u;
}

@DeleteMapping("/supprimer")
public String supprimer(Long id) {
	User u = this.userrespo.findById(id).get();
	this.userrespo.delete(u);
	return "user supprimer avec succées";
}

@PutMapping("/modifier")
public String modifier(Long id) {
	User u = this.userrespo.findById(id).get();
	u.setPrenom("formateur");
	this.userrespo.save(u);
	return "modification a été avec succées" ; 
}


@Autowired
private PasswordEncoder encoder ; 


@PostMapping("/ajouteravecrole")
public String ajouteravecrole(@RequestBody User u ,String profil ) {
	User user = this.userrespo.findByEmail(u.getEmail());
	if(user==null) {
	Role r = this.rolerepos.findByProfil(profil);
	//cryptage pour le password 
	String pass = encoder.encode(u.getPassword());
	
	u.setPassword(pass);
	u.setRole(r);
	
	
	this.userrespo.save(u);
	return "true";
	}
	else {
		return "email existe deja";
	}
	
}

@GetMapping("/afficherbyrole")
public List<User> afficherbyrole(String profil){
	Role r = this.rolerepos.findByProfil(profil);
	return this.userrespo.findByRole(r);
	
}





}