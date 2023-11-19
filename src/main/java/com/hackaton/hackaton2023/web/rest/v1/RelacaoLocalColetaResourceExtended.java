package com.hackaton.hackaton2023.web.rest.v1;

import com.hackaton.hackaton2023.domain.RelacaoLocalColeta;
import com.hackaton.hackaton2023.repository.RelacaoLocalColetaRepository;
import com.hackaton.hackaton2023.service.UserService;
import com.hackaton.hackaton2023.service.RelacaoLocalColetaQueryService;
import com.hackaton.hackaton2023.service.dto.AdminUserDTO;
import com.hackaton.hackaton2023.service.v1.RelacaoLocalColetaServiceExtended;
import com.hackaton.hackaton2023.web.rest.RelacaoLocalColetaResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class RelacaoLocalColetaResourceExtended extends RelacaoLocalColetaResource {

    private final RelacaoLocalColetaServiceExtended relacaoLocalColetaServiceExtended;
    private final UserService userService;

    public RelacaoLocalColetaResourceExtended(RelacaoLocalColetaServiceExtended relacaoLocalColetaServiceExtended, RelacaoLocalColetaRepository relacaoLocalColetaRepository, RelacaoLocalColetaQueryService relacaoLocalColetaQueryService, UserService userService) {
        super(relacaoLocalColetaServiceExtended, relacaoLocalColetaRepository, relacaoLocalColetaQueryService);
        this.relacaoLocalColetaServiceExtended = relacaoLocalColetaServiceExtended;
        this.userService = userService;
    }

}
