package com.alura.GuillermoDardonChallengeForoHub.foro_hub.security;

import com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

@Value("${jwt.secret}")
private String secret;

@Value("${jwt.expiration}")
private Long expiration;

public String generarToken(Usuario usuario) {

    try {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withSubject(usuario.getUsername())
                .withIssuer("foro_hub")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(algorithm);
        return token;
    } catch (JWTCreationException exception) {
        throw new RuntimeException("Error generando el token JWT", exception);
    }

}

public String getSubject(String tokenJWT) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("foro_hub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT invalido o expirado");
        }

    }

}


