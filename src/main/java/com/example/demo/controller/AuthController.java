package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitie.LoginReponse;
import com.example.demo.entitie.LoginRequest;
import com.example.demo.entitie.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenUtils;

@RestController
@RequestMapping("auth")

public class AuthController {

@Autowired 
AuthenticationManager authenticationManager ;
@Autowired
JwtTokenUtils jwtTokenUtils ; 
@Autowired
UserRepository userepos ; 
@PostMapping("/login")
public ResponseEntity<LoginReponse> login(@Valid @RequestBody LoginRequest loginRequest)
{

	  Authentication authentication = authenticationManager.authenticate(
           new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
	  SecurityContextHolder.getContext().setAuthentication(authentication);
   UserDetails userDetails = (UserDetails) authentication.getPrincipal();
   String token = this.jwtTokenUtils.generateToken(userDetails);

	
	User c =this.userepos.findByEmail(loginRequest.getEmail());
	
 return ResponseEntity.ok(new LoginReponse(token,"Bearer","Login Succesful",c.getRole().getProfil(),c.getEmail()));
 

}
	
}
