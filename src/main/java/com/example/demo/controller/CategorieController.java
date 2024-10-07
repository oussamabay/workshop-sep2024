package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Categorie;
import com.example.demo.repository.CategoriRepository;

@RestController
@RequestMapping("cat")
public class CategorieController {

@Autowired
CategoriRepository catrepos ; 


@PostMapping("ajouter")
public String ajouter(@RequestBody Categorie c) {
	this.catrepos.save(c);
	return "ajouter avec succées";
}

	
}
