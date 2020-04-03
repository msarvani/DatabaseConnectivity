package com.foodhub.database.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class SaltCreationService {

	public String createSalt() {
		
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[20];
		random.nextBytes(bytes);
		
		StringBuilder sb = new StringBuilder();
		for(byte b: bytes) {
			sb.append(Byte.toString(b));
		}
		return sb.toString();
	}
}
