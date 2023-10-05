package com.dnb.apigatewayservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${jwt.secret}")
	private String jwtSecret;

	public Claims getClaims(final String token) {
		// parse token using secret key

		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean validateJwtToken(String authToken) {
		// validate token

		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
		} catch (ExpiredJwtException e) {
			LOGGER.error("JwtUtils | validateJwtToken | Invalid JWT signature: {}", e.getMessage());
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			LOGGER.error("JwtUtils | validateJwtToken | Invalid JWT signature: {}", e.getMessage());
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			LOGGER.error("JwtUtils | validateJwtToken | Invalid JWT signature: {}", e.getMessage());
			e.printStackTrace();
		} catch (SignatureException e) {
			LOGGER.error("JwtUtils | validateJwtToken | Invalid JWT signature: {}", e.getMessage());
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			LOGGER.error("JwtUtils | validateJwtToken | Invalid JWT signature: {}", e.getMessage());
			e.printStackTrace();
		}

		return false;
	}
}
