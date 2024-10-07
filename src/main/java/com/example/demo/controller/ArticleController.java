package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Article;
import com.example.demo.repository.ArticleRepositry;

@RestController
@RequestMapping("article")
public class ArticleController {

@Autowired
ArticleRepositry articlerepos ; 

//CRUD(AJOUT - Modif -Suppression - Affichage) 

@PostMapping("ajouter")
public String Ajouter(@RequestBody Article article) {
	
	Article a = this.articlerepos.findByName(article.getName());
	if(a==null) {
		this.articlerepos.save(article);
		return "article enregistrer avec succée" ;
	}
	else {
		return "article existe deja";
	}
}


@GetMapping("affichage")
public List<Article> affichage(){
	
	return this.articlerepos.findAll(); 
	
}

@GetMapping("affichagebyid")
public Article affichagebyid(Long id){
	Article a = this.articlerepos.findById(id).get();
	return a ; 
}

@PutMapping("modification")
public String modifier(@RequestBody Article article){
	Article a = this.articlerepos.findById(article.getId()).get();
	a.setDescription(article.getDescription());
	a.setName(article.getName());
	a.setPrix(article.getPrix());
	this.articlerepos.save(a);
	return "modifier avec succée";
	
}

@DeleteMapping("supprimer")
public String supprimer(Long id) {
	Article a  = this.articlerepos.findById(id).get();
	this.articlerepos.delete(a);
	return "supprimer avec succées";
}


}
