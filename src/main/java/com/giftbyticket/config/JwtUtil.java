package com.giftbyticket.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "giftbyticketsecretkeygiftbyticketsecretkey".getBytes());

    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis()
                                + 1000 * 60 * 60 * 24))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {

        return extractClaims(token).getSubject();
    }

    public boolean validateToken(String token, String email) {

        return extractUsername(token).equals(email);
    }

    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}