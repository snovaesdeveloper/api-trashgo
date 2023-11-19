package com.hackaton.hackaton2023.web.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackaton.hackaton2023.domain.Usuario;
import com.hackaton.hackaton2023.security.jwt.JWTFilter;
import com.hackaton.hackaton2023.security.jwt.TokenProvider;
import com.hackaton.hackaton2023.service.v1.UsuarioServiceExtended;
import com.hackaton.hackaton2023.web.rest.vm.LoginVM;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api/v1")
public class UserJWTController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UsuarioServiceExtended usuarioServiceExtended;

    public UserJWTController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UsuarioServiceExtended usuarioServiceExtended) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.usuarioServiceExtended = usuarioServiceExtended;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginVM loginVM) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            loginVM.getUsername(),
            loginVM.getPassword()
        );

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, loginVM.isRememberMe());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        Optional<Usuario> usuario = usuarioServiceExtended.findOneByLogin(loginVM.getUsername());

        return new ResponseEntity<>(new JWTToken(jwt, usuario.orElse(null)), httpHeaders, HttpStatus.OK);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;
        private Usuario usuario;

        JWTToken(String idToken, Usuario usuario) {
            this.idToken = idToken;
            this.usuario = usuario;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
    }
}
