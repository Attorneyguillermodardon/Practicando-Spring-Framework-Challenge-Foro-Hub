package com.alura.GuillermoDardonChallengeForoHub.foro_hub.controller;

import com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.usuario.DatosAutenticacion;
import com.alura.GuillermoDardonChallengeForoHub.foro_hub.domain.usuario.Usuario;
import com.alura.GuillermoDardonChallengeForoHub.foro_hub.security.DatosTokenJWT;
import com.alura.GuillermoDardonChallengeForoHub.foro_hub.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosTokenJWT> IniciarSesion(@RequestBody @Valid DatosAutenticacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.password());
        var autenticacion  = manager.authenticate(authenticationToken);
        var usuario = (Usuario) autenticacion.getPrincipal();
        var jwt = tokenService.generarToken(usuario);
        return ResponseEntity.ok(new DatosTokenJWT(jwt));
    }


}
