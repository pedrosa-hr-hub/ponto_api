package com.example.pontoapi.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "${SECRET_KEY_JWT}";

    // Extrai o usuario do token
    public String extraiUsuario(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Vê se o token está expirado
    private boolean isTokenExpirado(String token) {
        try {

            final Date expiration = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();

            return expiration.after(new Date());

        } catch (Exception e) {

            return false;

        }

    }

}