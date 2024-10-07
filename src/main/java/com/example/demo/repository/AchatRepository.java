package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitie.Achat;
import com.example.demo.entitie.Article;
import com.example.demo.entitie.User;

public interface AchatRepository extends JpaRepository<Achat, Long> {

	List<Achat> findByUser(User u);

	List<Achat> findByArticle(Article a);

}
