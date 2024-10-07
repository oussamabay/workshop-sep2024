package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.Achat;
import com.example.demo.entitie.Article;
import com.example.demo.entitie.User;
import com.example.demo.repository.AchatRepository;
import com.example.demo.repository.ArticleRepositry;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("achat")
public class AchatController {

@Autowired
AchatRepository achatrepos ; 
@Autowired
UserRepository userrepos ;
@Autowired
ArticleRepositry articlerepos; 

@PostMapping("acheter")
public String acheter(String email,String nom) {
	User u = this.userrepos.findByEmail(email);
	Article a = this.articlerepos.findByName(nom);
	Achat achat = new Achat();
	achat.setArticle(a);
	achat.setUser(u);
	this.achatrepos.save(achat);
	return "achat enregistre";
}


@GetMapping("afficherbyuser")
public List<Achat> afficher(String email){
	User u = this.userrepos.findByEmail(email);
	return this.achatrepos.findByUser(u);
}

@GetMapping("afficherbyarticle")
public List<Achat> afficherbyarticle(Long article) {
	Article a = this.articlerepos.findById(article).get();
	return this.achatrepos.findByArticle(a);
	
	
}




}
