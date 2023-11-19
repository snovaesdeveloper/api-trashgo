package com.hackaton.hackaton2023.repository.v1;

import com.hackaton.hackaton2023.domain.Usuario;
import com.hackaton.hackaton2023.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface UsuarioRepositoryExtended extends UsuarioRepository {
    Optional<Usuario> findOneByLogin(String username);
}
