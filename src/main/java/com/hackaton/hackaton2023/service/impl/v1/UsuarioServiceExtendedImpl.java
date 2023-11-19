package com.hackaton.hackaton2023.service.impl.v1;

import com.hackaton.hackaton2023.domain.Usuario;
import com.hackaton.hackaton2023.repository.UsuarioRepository;
import com.hackaton.hackaton2023.repository.v1.UsuarioRepositoryExtended;
import com.hackaton.hackaton2023.service.impl.UsuarioServiceImpl;
import com.hackaton.hackaton2023.service.v1.UsuarioServiceExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Primary
public class UsuarioServiceExtendedImpl extends UsuarioServiceImpl implements UsuarioServiceExtended {

    private final UsuarioRepositoryExtended usuarioRepositoryExtended;

    public UsuarioServiceExtendedImpl(UsuarioRepositoryExtended usuarioRepositoryExtended) {
        super(usuarioRepositoryExtended);
        this.usuarioRepositoryExtended = usuarioRepositoryExtended;
    }

    @Override
    public Optional<Usuario> findOneByLogin(String username) {
        return usuarioRepositoryExtended.findOneByLogin(username);
    }

}
