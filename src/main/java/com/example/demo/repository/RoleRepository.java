package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitie.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByProfil(String profil);

}
