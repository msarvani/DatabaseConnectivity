package com.foodhub.database.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.foodhub.database.model.DetailsRepository;

@Component
public class AuthenticationService {
	
	@Autowired
	HashPasswordService hashPassword;
	
	@Autowired
	SaltCreationService saltCreation;
	
	@Autowired
	DetailsRepository detailsRepository;
	
	public Boolean authenticate(String username, String password) throws NoSuchAlgorithmException {
		String runTimePassword = hashPassword.hashPassword(password, detailsRepository.findByuserName(username).get(0).getSalt());
		String dbPassword = detailsRepository.findByuserName(username).get(0).getPasswordValue();
		return runTimePassword.equals(dbPassword);
	}
	
	public String getSalt(String username) {
		return detailsRepository.findByuserName(username).get(0).getSalt();
	}
}
