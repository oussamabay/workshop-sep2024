package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entitie.Role;
import com.example.demo.entitie.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

   
    @Autowired
    UserRepository userrepos ;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	//tester email null
    	if (email.trim().isEmpty()) {
            throw new UsernameNotFoundException("username is empty");
        }
        User c = this.userrepos.findByEmail(email);

        if (c == null) {
            throw new UsernameNotFoundException("User with email = " + email + " not found");
        }

        return new org.springframework.security.core.userdetails.User(c.getUsername(), c.getPassword(), getGrantedAuthorities(c));
    }
    
    @Autowired
    RoleRepository rolerepos ; 
     
    // profil pour l'utilisateur connecter
    
    private List<GrantedAuthority> getGrantedAuthorities(User compte) {
       	 List<GrantedAuthority> authorities = new ArrayList<>(); 
       	 Role auth = this.rolerepos.findByProfil(compte.getRole().getProfil());
        authorities.add(new SimpleGrantedAuthority(auth.getProfil())); 
        return authorities; 
        }
}
