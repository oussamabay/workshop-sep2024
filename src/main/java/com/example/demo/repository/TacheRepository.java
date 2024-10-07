package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitie.Tache;
import com.example.demo.entitie.User;

public interface TacheRepository extends JpaRepository<Tache, Long> {

	List<Tache> findByUser(User u);

}
