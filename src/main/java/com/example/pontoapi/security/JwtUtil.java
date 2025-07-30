package com.example.pontoapi.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "${SECRET_KEY_JWT}";

    // Gera o token JWT
    public String gerarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

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
        final Date expiration = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }

    // Vendo se o token é valido
    public boolean validarToken(String token, UserDetails userDetails) {
        final String username = extraiUsuario(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpirado(token);
    }

}