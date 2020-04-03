package com.foodhub.database.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class HashPasswordService {
	
	public String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
		
		String passwordToBeHashed = password+salt;
		String hashPassword = null;
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] messageDigest = md.digest(passwordToBeHashed.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<messageDigest.length; i++) {
			sb.append(Integer.toString((messageDigest[i] & 0xff)+ 0x100, 16).substring(1));
		}
		
		hashPassword = sb.toString();
		return hashPassword;
	}

}
