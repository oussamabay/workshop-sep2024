package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitie.Categorie;

public interface CategoriRepository extends JpaRepository<Categorie, Long> {

	Categorie findByNom(String nomcategorie);

}
