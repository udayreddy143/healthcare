package com.vishva.admindoctoraccess.jwtUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTToken {

    private final String SECRET_KEY = "your-secrete-bit-jaswincode-craft-your-256-bit-secret"; // Use a secure key
    private final long EXPIRATION_TIME = 1000 * 60; // 1 minute

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username,Long adminId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", adminId);
        claims.put("username", username);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}
