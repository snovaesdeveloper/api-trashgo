package com.hackaton.hackaton2023.service.impl;

import com.hackaton.hackaton2023.domain.Usuario;
import com.hackaton.hackaton2023.repository.UsuarioRepository;
import com.hackaton.hackaton2023.service.UsuarioService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Usuario}.
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        log.debug("Request to save Usuario : {}", usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> partialUpdate(Usuario usuario) {
        log.debug("Request to partially update Usuario : {}", usuario);

        return usuarioRepository
            .findById(usuario.getId())
            .map(
                existingUsuario -> {
                    if (usuario.getNome() != null) {
                        existingUsuario.setNome(usuario.getNome());
                    }
                    if (usuario.getPerfil() != null) {
                        existingUsuario.setPerfil(usuario.getPerfil());
                    }
                    if (usuario.getLogin() != null) {
                        existingUsuario.setLogin(usuario.getLogin());
                    }
                    if (usuario.getSenha() != null) {
                        existingUsuario.setSenha(usuario.getSenha());
                    }

                    return existingUsuario;
                }
            )
            .map(usuarioRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        log.debug("Request to get all Usuarios");
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findOne(Long id) {
        log.debug("Request to get Usuario : {}", id);
        return usuarioRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Usuario : {}", id);
        usuarioRepository.deleteById(id);
    }
}
