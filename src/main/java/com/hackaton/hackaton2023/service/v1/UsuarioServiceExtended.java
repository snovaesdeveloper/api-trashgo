package com.hackaton.hackaton2023.service.v1;

import com.hackaton.hackaton2023.domain.Usuario;
import com.hackaton.hackaton2023.service.UsuarioService;

import java.util.Optional;

public interface UsuarioServiceExtended extends UsuarioService {
    Optional<Usuario> findOneByLogin(String username);
}
