package com.peruallure.peruallure.tienda.security;

import jakarta.servlet.http.HttpServletRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {

    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);  // Generar clave secreta para HS512
    private final long expirationTime = 86400000L; // 1 día

    // Generar el token JWT
    public String generateToken(Authentication authentication) {
        return Jwts.builder()
                .setSubject(authentication.getName())  // Establecer el nombre de usuario como "subject"
                .setIssuedAt(new Date())  // Establecer la fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))  // Establecer la fecha de expiración
                .signWith(key)  // Firmar el token con la clave secreta
                .compact();
    }

    // Validar el token JWT
    public boolean validateToken(String token) {
        try {
            // Crear el JwtParser usando builder y build()
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(key)  // Configurar la clave secreta
                    .build();  // Construir el JwtParser
            parser.parseClaimsJws(token);  // Intentar parsear el JWT
            return true;  // Si no hay excepción, el token es válido
        } catch (Exception e) {
            return false;  // Si ocurre una excepción, el token no es válido
        }
    }

    // Obtener el nombre de usuario desde el token JWT
    public String getUsernameFromToken(String token) {
        // Crear el JwtParser usando builder y build()
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(key)  // Configurar la clave secreta
                .build();  // Construir el JwtParser
        Claims claims = parser.parseClaimsJws(token).getBody();  // Parsear el JWT y obtener el cuerpo (claims)
        return claims.getSubject();  // Retornar el "subject", que es el nombre de usuario
    }

    // Extraer el token del encabezado de la solicitud HTTP
    public String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);  // Extraer el token quitando "Bearer "
        }

        return null;  // Si no hay token en el encabezado, retornar null
    }
}
