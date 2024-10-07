package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Categorie;
import com.example.demo.entitie.Tache;
import com.example.demo.entitie.User;
import com.example.demo.repository.CategoriRepository;
import com.example.demo.repository.TacheRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("tache")
public class TacheController {

	
@Autowired
TacheRepository tacherepos ; 
@Autowired
UserRepository userrepos ; 
@Autowired
CategoriRepository catrepos ; 



@PostMapping("creer")
public String creertache(@RequestBody Tache t , String email) {
	User u = this.userrepos.findByEmail(email);
	if(u==null) {
		return "email n'existe pas ";
	}
	else {
		t.setUser(u);
		this.tacherepos.save(t);
		return "creation tache avec succées";
	}
	
}




@PostMapping("creeravecdeuxrelation")
public String creeravecdeuxrelation(@RequestBody Tache t , String email,String nomcategorie) {
	User u = this.userrepos.findByEmail(email);
	Categorie  c = this.catrepos.findByNom(nomcategorie);
	if(u==null) {
		return "email n'existe pas ";
	}
	else {
		t.setCat(c);
		t.setUser(u);
		this.tacherepos.save(t);
		return "creation tache avec succées";
	}
	
}







@GetMapping("alltache")
public List<Tache> alltache(){
	return this.tacherepos.findAll();
}

@GetMapping("tachebyuser")
public List<Tache> tachebyuser(String email){
	User u = this.userrepos.findByEmail(email);
	return this.tacherepos.findByUser(u);
	
	
}

}
