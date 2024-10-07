package com.example.demo.entitie;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginReponse {
	@NonNull
	private String token ;
	@NonNull
	private String type ;
	@NonNull
	private String message ;
	@NonNull
	private String profil ;
	@NonNull
	private String email ;
	
}
