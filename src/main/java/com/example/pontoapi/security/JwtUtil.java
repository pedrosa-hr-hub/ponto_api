package com.example.pontoapi.security;

import java.util.Date;
import java.nio.charset.StandardCharsets;
import java.security.Key;

import org.springframework.stereotype.Component;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final Key key;

    public JwtUtil() {
        Dotenv dotenv = Dotenv.load();
        String secret = dotenv.get("JWT_SECRET_KEY");

        if (secret == null || secret.length() < 32) {
            throw new IllegalArgumentException("JWT_SECRET_KEY ausente ou curta demais");
        }

        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String extraiUsuario(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpirado(String token) {
        try {
            Date expiration = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();

            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
}
