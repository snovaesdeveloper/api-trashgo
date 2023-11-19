package com.hackaton.hackaton2023.web.rest.v1;

import com.hackaton.hackaton2023.domain.User;
import com.hackaton.hackaton2023.domain.Usuario;
import com.hackaton.hackaton2023.repository.UsuarioRepository;
import com.hackaton.hackaton2023.service.UserService;
import com.hackaton.hackaton2023.service.UsuarioQueryService;
import com.hackaton.hackaton2023.service.UsuarioService;
import com.hackaton.hackaton2023.service.dto.AdminUserDTO;
import com.hackaton.hackaton2023.service.v1.UsuarioServiceExtended;
import com.hackaton.hackaton2023.web.rest.UsuarioResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UsuarioResourceExtended extends UsuarioResource {

    private final UsuarioServiceExtended usuarioServiceExtended;
    private final UserService userService;

    public UsuarioResourceExtended(UsuarioServiceExtended usuarioServiceExtended, UsuarioRepository usuarioRepository, UsuarioQueryService usuarioQueryService, UserService userService) {
        super(usuarioServiceExtended, usuarioRepository, usuarioQueryService);
        this.usuarioServiceExtended = usuarioServiceExtended;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) throws URISyntaxException {

        AdminUserDTO user = new AdminUserDTO();
        user.setLogin(usuario.getLogin());
        user.setPassword(usuario.getSenha());
        user.setActivated(true);
        user.setFirstName(usuario.getNome());

        usuario.setUser(userService.createUser(user));

        return super.createUsuario(usuario);

    }

    @Override
    public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id", required = false) final Long id, @RequestBody Usuario usuario) throws URISyntaxException {

        AdminUserDTO userDTO = new AdminUserDTO();
        userDTO.setId(usuario.getUser().getId());
        userDTO.setLogin(usuario.getLogin());
        userDTO.setFirstName(usuario.getNome());
        userService.updateUser(userDTO);

        return super.updateUsuario(id, usuario);

    }

}
