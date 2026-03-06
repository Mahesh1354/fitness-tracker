package com.project.fitness.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    // 🔐 Secret key (minimum 256-bit for HS256)
    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    // ⏱ Token validity (24 hours)
    private static final long JWT_EXPIRATION_MS = 24 * 60 * 60 * 1000;

    // ===============================
    // Generate JWT Token
    // ===============================
    public String generateToken(String userId, String role) {

        return Jwts.builder()
                .setSubject(userId)
                .claim("roles", List.of(role))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ===============================
    // Extract User ID from Token
    // ===============================
    public String getUserIdFromToken(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    // ===============================
    // Extract Roles from Token
    // ===============================
    public List<String> getRolesFromToken(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.get("roles", List.class);
    }

    // ===============================
    // Validate JWT Token
    // ===============================
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ===============================
    // Get Signing Key
    // ===============================
    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}
