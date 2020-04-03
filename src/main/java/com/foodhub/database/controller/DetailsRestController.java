package com.foodhub.database.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.foodhub.database.model.Details;
import com.foodhub.database.model.DetailsRepository;
import com.foodhub.database.model.FullNameDetails;
import com.foodhub.database.service.AuthenticationService;
import com.foodhub.database.service.HashPasswordService;
import com.foodhub.database.service.SaltCreationService;

@RestController
@RefreshScope
@RequestMapping(path = "/details")
public class DetailsRestController {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DetailsRepository detailsRepository;
	
	@Autowired
	SaltCreationService saltCreationService;
	
	@Autowired
	HashPasswordService hashPasswordService;
	
	@Autowired
	AuthenticationService authenticationService;
	
		
	@PostMapping("/savedetails")
	public String savePasswordDetailsInDataBase(@RequestBody FullNameDetails fullNameDetails) throws NoSuchAlgorithmException {
		detailsRepository.save(new Details(fullNameDetails.getUserName(), saltCreationService.createSalt(), 
				hashPasswordService.hashPassword(fullNameDetails.getPassword(), saltCreationService.createSalt())
				));
		return "PasswordDetails of user " + fullNameDetails.getUserName()+" added to database successfully";
	}
	
	@GetMapping("/fetchUserDetailsFromUsername/{username}")
	public List<Details> getUserDetailsFromUserName(@PathVariable String username){
		return detailsRepository.findByuserName(username);
	}
	
	@PostMapping("/authenticate")
	public Boolean authenticateUser(@RequestBody FullNameDetails fullNameDetails) throws NoSuchAlgorithmException {
		return authenticationService.authenticate(fullNameDetails.getUserName(), fullNameDetails.getPassword());
	}
	
	@GetMapping("/fetchAllUserDetails")
	public List<Details> getUserDetails(){
		return detailsRepository.findAll();
	}
	
	@DeleteMapping("/deleteDetailsByUserName/{username}")
	public String deleteuserDetails(@PathVariable String username) {
		detailsRepository.deleteByuserName(username);
		return "Details of the specified user "+username+" deleted successfully";
	}
	
	@GetMapping("/searchbyUserName/{username}")
	public String searchUser(@PathVariable String username) {
		detailsRepository.findByuserName(username);
		return "Valid User";
	}
}
