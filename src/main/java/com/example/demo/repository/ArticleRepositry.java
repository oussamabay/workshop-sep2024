package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitie.Article;

public interface ArticleRepositry extends JpaRepository<Article, Long>  {

	Article findByName(String name);

}
