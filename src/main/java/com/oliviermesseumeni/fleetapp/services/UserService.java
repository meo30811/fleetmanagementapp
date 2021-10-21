package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.User;
import com.oliviermesseumeni.fleetapp.repositories.UserRepository;

@Service
public class UserService {
	
     @Autowired 
     private BCryptPasswordEncoder encoder;
	
	@Autowired 
	private UserRepository userRepository;

	public void save(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		userRepository.save(user);
	}
}
