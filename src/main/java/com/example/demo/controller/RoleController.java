package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Role;
import com.example.demo.repository.RoleRepository;

@RestController
@RequestMapping("role")
public class RoleController {

@Autowired
RoleRepository rolerepos ; 

@PostMapping("/ajouter")
public boolean ajouter(@RequestBody Role r) {
	
	Role  role = this.rolerepos.findByProfil(r.getProfil());
	if(role!= null) {
		return false ; 
	}
	else {
		this.rolerepos.save(r);
		return true ; 
	}
	
}
	
@GetMapping("/afficher")
public List<Role>afficher(){
	return this.rolerepos.findAll();
}

}
