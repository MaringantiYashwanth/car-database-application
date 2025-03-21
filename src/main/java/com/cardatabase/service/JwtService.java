package com.cardatabase.service;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtService {
	static final Long EXPIRATION_TIME = 86400000L;
	// 1 day in MS. Should be shorter in production.
	static final String prefix = "Bearer";
	// Generated secret key only for demo
	// In production read it from the app configuration.
//	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	static final Key key = Keys
	
}
